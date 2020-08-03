package cn.yt4j.seckilldemo.service.impl;

import cn.yt4j.seckilldemo.dao.SuccessKilledDao;
import cn.yt4j.seckilldemo.entity.SuccessKilled;
import cn.yt4j.seckilldemo.service.SuccessKilledService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 秒杀成功明细表(SuccessKilled)表服务实现类
 *
 * @author shichenyang
 * @since 2020-07-18 10:33:57
 */
@Service("successKilledService")
public class SuccessKilledServiceImpl extends ServiceImpl<SuccessKilledDao, SuccessKilled> implements SuccessKilledService {

}