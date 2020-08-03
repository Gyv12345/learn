package cn.yt4j.mybatisplusdemo.enums;

/**
 * @author shichenyang
 */
public interface BaseEnum<E extends Enum<?>, T> {
    Integer getCode();

    String getText();
}
