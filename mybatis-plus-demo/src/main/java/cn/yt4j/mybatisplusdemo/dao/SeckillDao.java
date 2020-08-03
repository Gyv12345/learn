package cn.yt4j.mybatisplusdemo.dao;

import cn.yt4j.mybatisplusdemo.entity.Seckill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀库存表(Seckill)表数据库访问层
 *
 * @author shichenyang
 * @since 2020-07-28 15:58:05
 */
@Mapper
public interface SeckillDao extends BaseMapper<Seckill> {

}