package cn.yt4j.mybatisplusdemo.service.impl;

import cn.yt4j.mybatisplusdemo.dao.SeckillDao;
import cn.yt4j.mybatisplusdemo.entity.Seckill;
import cn.yt4j.mybatisplusdemo.service.SeckillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 秒杀库存表(Seckill)表服务实现类
 *
 * @author shichenyang
 * @since 2020-07-28 15:58:07
 */
@Service("seckillService")
public class SeckillServiceImpl extends ServiceImpl<SeckillDao, Seckill> implements SeckillService {

}