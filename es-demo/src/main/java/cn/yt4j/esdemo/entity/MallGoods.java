package cn.yt4j.esdemo.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


/**
 * 商品基本信息表(MallGoods)表实体类
 *
 * @author shichenyang
 * @since 2020-07-08 17:16:34
 */
@ApiModel(value="MallGoods对象",description="商品基本信息表")
@Getter
@Setter
@ToString
@TableName("mall_goods")
@Document(indexName = "MallGoods")
public class MallGoods extends Model<MallGoods> {

    @Id
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Integer id;
    
    private Integer brandId;
    
    @ApiModelProperty(value = "商品所属类目ID",example = "1")
    private Integer categoryId;
    
    @ApiModelProperty(value = "租户id",example = "1")
    private Integer tenantId;

    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "商品编号",example = "1")
    private String goodsSn;

    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    @ApiModelProperty(value = "商品名称",example = "1")
    private String name;
    
    @ApiModelProperty(value = "商品宣传图片列表，采用JSON数组格式",example = "1")
    private String gallery;

    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    @ApiModelProperty(value = "商品关键字，采用逗号间隔",example = "1")
    private String keywords;

    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    @ApiModelProperty(value = "商品简介",example = "1")
    private String brief;
    
    @ApiModelProperty(value = "排序",example = "1")
    private Integer sort;
    
    @ApiModelProperty(value = "商品页面商品图片",example = "1")
    private String picUrl;
    
    @ApiModelProperty(value = "商品分享朋友圈图片",example = "1")
    private String shareUrl;
    
    @ApiModelProperty(value = "商品单位，例如件、盒",example = "1")
    private String unit;
    
    @ApiModelProperty(value = "专柜价格",example = "1")
    private Double counterPrice;
    
    @ApiModelProperty(value = "零售价格",example = "1")
    private Double retailPrice;

    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    @ApiModelProperty(value = "商品详细介绍，是富文本格式",example = "1")
    private String detail;
    
    @ApiModelProperty(value = "是否上架",example = "1")
    private Integer isOnSale;
    
    @ApiModelProperty(value = "是否人气推荐，如果设置则可以在人气推荐页面展示",example = "1")
    private Integer isHot;
    
    @ApiModelProperty(value = "是否新品首发，如果设置则可以在新品首发页面展示",example = "1")
    private Integer isNew;
    
    @ApiModelProperty(value = "是否平台推荐，如果设置则可以在PC端页面展示",example = "1")
    private Integer isRecommend;
    
    @ApiModelProperty(value = "逻辑删除(0:为删除，1:删除)",example = "1")
    private Integer deleted;
    
    @ApiModelProperty(value = "创建时间",example = "1")
    private Date createTime;
    
    @ApiModelProperty(value = "更新时间",example = "1")
    private Date updateTime;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }