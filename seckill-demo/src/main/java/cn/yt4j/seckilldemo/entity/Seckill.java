package cn.yt4j.seckilldemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
 * 秒杀库存表(Seckill)表实体类
 *
 * @author shichenyang
 * @since 2020-07-18 10:33:50
 */
@ApiModel(value = "Seckill对象", description = "秒杀库存表")
@Getter
@Setter
@ToString
@TableName("seckill")
public class Seckill extends Model<Seckill> {

    @TableId
    @ApiModelProperty(value = "商品库存id", example = "1")
    private Long seckillId;

    @ApiModelProperty(value = "商品名称", example = "1")
    private String name;

    @ApiModelProperty(value = "库存数量", example = "1")
    private Integer number;

    @ApiModelProperty(value = "秒杀开启时间", example = "1")
    private Date startTime;

    @ApiModelProperty(value = "秒杀结束时间", example = "1")
    private Date endTime;

    @ApiModelProperty(value = "创建时间", example = "1")
    private Date createTime;

    @ApiModelProperty(value = "版本号", example = "1")
    private Integer version;


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