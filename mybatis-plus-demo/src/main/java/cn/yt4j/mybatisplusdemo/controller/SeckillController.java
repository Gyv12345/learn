package cn.yt4j.mybatisplusdemo.controller;


import cn.yt4j.mybatisplusdemo.entity.Seckill;
import cn.yt4j.mybatisplusdemo.service.SeckillService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 秒杀库存表(Seckill)表控制层
 *
 * @author shichenyang
 * @since 2020-07-28 15:58:07
 */
@AllArgsConstructor
@RestController
@RequestMapping("seckill")
public class SeckillController {
    /**
     * 服务对象
     */
    private final SeckillService seckillService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param seckill 查询实体
     * @return 所有数据
     */
    @GetMapping("list")
    public R<Page<Seckill>> selectAll(Page<Seckill> page, Seckill seckill) {
        return R.ok(this.seckillService.page(page, new QueryWrapper<>(seckill)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R<Seckill> selectOne(@PathVariable Serializable id) {
        return R.ok(this.seckillService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param seckill 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Seckill seckill) {
        return R.ok(this.seckillService.save(seckill));
    }

    /**
     * 修改数据
     *
     * @param seckill 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Seckill seckill) {
        return R.ok(this.seckillService.updateById(seckill));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return R.ok(this.seckillService.removeByIds(idList));
    }
}