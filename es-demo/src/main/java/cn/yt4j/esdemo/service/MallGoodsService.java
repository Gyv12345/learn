package cn.yt4j.esdemo.service;

import cn.yt4j.esdemo.es.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.yt4j.esdemo.entity.MallGoods;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 商品基本信息表(MallGoods)表服务接口
 *
 * @author shichenyang
 * @since 2020-07-08 17:16:35
 */
public interface MallGoodsService extends IService<MallGoods> {


    int importAll();

    Page<Goods> search(String q);

    int delete();

    Goods getOne(Integer id);
}