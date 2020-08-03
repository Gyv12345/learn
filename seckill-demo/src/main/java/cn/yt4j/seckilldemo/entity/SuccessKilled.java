package cn.yt4j.seckilldemo.entity;

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
 * 秒杀成功明细表(SuccessKilled)表实体类
 *
 * @author shichenyang
 * @since 2020-07-18 10:33:57
 */
@ApiModel(value = "SuccessKilled对象", description = "秒杀成功明细表")
@Getter
@Setter
@ToString
@TableName("success_killed")
public class SuccessKilled extends Model<SuccessKilled> {

    @ApiModelProperty(value = "秒杀商品id", example = "1")
    private Long seckillId;

    @ApiModelProperty(value = "用户Id", example = "1")
    private Long userId;

    @ApiModelProperty(value = "状态标示：-1指无效，0指成功，1指已付款", example = "1")
    private Integer state;

    @ApiModelProperty(value = "创建时间", example = "1")
    private Date createTime;


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