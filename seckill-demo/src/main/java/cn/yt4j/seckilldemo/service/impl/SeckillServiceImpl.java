package cn.yt4j.seckilldemo.service.impl;

import cn.yt4j.seckilldemo.aop.Servicelock;
import cn.yt4j.seckilldemo.dao.SeckillDao;
import cn.yt4j.seckilldemo.dao.SuccessKilledDao;
import cn.yt4j.seckilldemo.entity.Seckill;
import cn.yt4j.seckilldemo.entity.SuccessKilled;
import cn.yt4j.seckilldemo.service.SeckillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 秒杀库存表(Seckill)表服务实现类
 *
 * @author shichenyang
 * @since 2020-07-18 10:33:54
 */
@AllArgsConstructor
@Service("seckillService")
public class SeckillServiceImpl extends ServiceImpl<SeckillDao, Seckill> implements SeckillService {

    private final SuccessKilledDao successKilledDao;

    @Transactional(rollbackFor = Exception.class)
    @Servicelock
    @Override
    public Boolean seckill(Long id, Long userId, Integer number) {
        Seckill seckill= baseMapper.selectById(id);
        if (seckill.getNumber()>=number){
            seckill.setNumber(seckill.getNumber()-1);
            int count= baseMapper.updateById(seckill);
            if (count>0){
                SuccessKilled killed=new SuccessKilled();
                killed.setSeckillId(id);
                killed.setUserId(userId);
                killed.setState(number);
                killed.setCreateTime(new Date());
                successKilledDao.insert(killed);
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }else {
            return Boolean.FALSE;
        }
    }
}