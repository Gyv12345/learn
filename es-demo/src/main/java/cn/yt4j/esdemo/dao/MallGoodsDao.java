package cn.yt4j.esdemo.dao;

import cn.yt4j.esdemo.entity.MallGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品基本信息表(MallGoods)表数据库访问层
 *
 * @author shichenyang
 * @since 2020-07-08 17:16:34
 */
@Mapper
public interface MallGoodsDao extends BaseMapper<MallGoods> {

}