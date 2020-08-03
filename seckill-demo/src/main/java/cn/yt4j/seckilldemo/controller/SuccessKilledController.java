package cn.yt4j.seckilldemo.controller;


import cn.yt4j.seckilldemo.entity.SuccessKilled;
import cn.yt4j.seckilldemo.service.SuccessKilledService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 秒杀成功明细表(SuccessKilled)表控制层
 *
 * @author shichenyang
 * @since 2020-07-18 10:33:57
 */
@AllArgsConstructor
@RestController
@RequestMapping("successKilled")
public class SuccessKilledController {
    /**
     * 服务对象
     */
    private final SuccessKilledService successKilledService;

    /**
     * 分页查询所有数据
     *
     * @param page          分页对象
     * @param successKilled 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SuccessKilled> page, SuccessKilled successKilled) {
        return R.ok(this.successKilledService.page(page, new QueryWrapper<>(successKilled)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.successKilledService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param successKilled 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SuccessKilled successKilled) {
        return R.ok(this.successKilledService.save(successKilled));
    }

    /**
     * 修改数据
     *
     * @param successKilled 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SuccessKilled successKilled) {
        return R.ok(this.successKilledService.updateById(successKilled));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return R.ok(this.successKilledService.removeByIds(idList));
    }
}