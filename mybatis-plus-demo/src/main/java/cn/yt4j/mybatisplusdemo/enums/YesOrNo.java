package cn.yt4j.mybatisplusdemo.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @Description:
 * @Author: shichenyang
 * @Company: 河南云数谷科技有限公司
 * @Date: 2020/7/22 16:39
 * @Version: @Version: V1.0
 */
public enum YesOrNo implements BaseEnum{
    Yes(1, "是"),
    No(0, "否");

    @JsonValue
    @EnumValue
    private Integer code;
    private String text;

    YesOrNo(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    @JsonCreator
    public static YesOrNo jsonCreate(Integer code) {
        for (YesOrNo yesOrNo : YesOrNo.values()){
            if(yesOrNo.getCode().equals(code)){
                return yesOrNo;
            }
        }
        return null;
    }


    @Override
    public Integer getCode() {
        return this.code;
    }


    @Override
    public String getText() {
        return this.text;
    }
}
