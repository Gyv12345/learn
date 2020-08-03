package cn.yt4j.spi;

/**
 * @author 定义接口
 */
@FunctionalInterface
public interface IRepository {
    /**
     * 保存数据
     */
    void save();
}
