package cn.yt4j.seckilldemo.service;

import cn.yt4j.seckilldemo.entity.Seckill;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 秒杀库存表(Seckill)表服务接口
 *
 * @author shichenyang
 * @since 2020-07-18 10:33:53
 */
public interface SeckillService extends IService<Seckill> {

    Boolean seckill(Long id,Long userId,Integer number);
}