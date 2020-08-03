package cn.yt4j.esdemo.controller;


import cn.yt4j.esdemo.entity.MallGoods;
import cn.yt4j.esdemo.service.MallGoodsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 商品基本信息表(MallGoods)表控制层
 *
 * @author shichenyang
 * @since 2020-07-08 17:16:35
 */
@Api(tags = "商品基本信息表")
@RestController
@RequestMapping("mallGoods")
public class MallGoodsController {
    /**
     * 服务对象
     */
    @Autowired
    private MallGoodsService mallGoodsService;

    @GetMapping("import")
    public R importAll() {
        this.mallGoodsService.importAll();
        return R.ok("");
    }

    @GetMapping("search")
    public R search(String q) {
        return R.ok(this.mallGoodsService.search(q));
    }

    @DeleteMapping("/del")
    public R delete(){
        this.mallGoodsService.delete();
        return R.ok("");
    }

    /**
     * 分页查询所有数据
     *
     * @param page      分页对象
     * @param mallGoods 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<MallGoods> page, MallGoods mallGoods) {
        return R.ok(this.mallGoodsService.page(page, new QueryWrapper<>(mallGoods)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Integer id) {
        return R.ok(this.mallGoodsService.getOne(id));
    }

    /**
     * 新增数据
     *
     * @param mallGoods 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody MallGoods mallGoods) {
        return R.ok(this.mallGoodsService.save(mallGoods));
    }

    /**
     * 修改数据
     *
     * @param mallGoods 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody MallGoods mallGoods) {
        return R.ok(this.mallGoodsService.updateById(mallGoods));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return R.ok(this.mallGoodsService.removeByIds(idList));
    }
}