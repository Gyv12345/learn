package cn.yt4j.esdemo.service.impl;

import cn.yt4j.esdemo.dao.MallGoodsDao;
import cn.yt4j.esdemo.entity.MallGoods;
import cn.yt4j.esdemo.es.Goods;
import cn.yt4j.esdemo.repository.EsProductRespository;
import cn.yt4j.esdemo.service.MallGoodsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品基本信息表(MallGoods)表服务实现类
 *
 * @author shichenyang
 * @since 2020-07-08 17:16:35
 */
@Service("mallGoodsService")
public class MallGoodsServiceImpl extends ServiceImpl<MallGoodsDao, MallGoods> implements MallGoodsService {

    @Autowired
    private EsProductRespository esProductRespository;


    @Override
    public int importAll() {

        List<MallGoods> list=baseMapper.selectList(new QueryWrapper<>());

        List<Goods> goodsList=list.stream().map(mallGoods -> {
            Goods goods=new Goods();
            BeanUtils.copyProperties(mallGoods,goods);
            return goods;
        }).collect(Collectors.toList());
        this.esProductRespository.saveAll(goodsList);

        return 0;
    }

    @Override
    public Page<Goods> search(String q) {
        return  this.esProductRespository.findByNameOrBriefOrKeywordsOrDetail(q,q,q,q, PageRequest.of(0,10));
    }

    @Override
    public int delete() {
        this.esProductRespository.deleteAll();
        return 0;
    }

    @Override
    public Goods getOne(Integer id) {
        return this.esProductRespository.findById(id).get();
    }
}