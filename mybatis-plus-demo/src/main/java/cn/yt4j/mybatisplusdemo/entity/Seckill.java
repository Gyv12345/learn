package cn.yt4j.mybatisplusdemo.entity;

import cn.yt4j.mybatisplusdemo.enums.YesOrNo;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 秒杀库存表(Seckill)表实体类
 *
 * @author shichenyang
 * @since 2020-07-28 15:58:04
 */
@Getter
@Setter
@ToString
@TableName("seckill")
public class Seckill extends Model<Seckill> {

    private Long seckillId;

    private String name;

    private Integer number;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDateTime createTime;

    private Integer version;

    private YesOrNo state;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.seckillId;
    }
}