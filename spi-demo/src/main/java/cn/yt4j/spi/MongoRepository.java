package cn.yt4j.spi;

/**
 * @author gyv12
 */
public class MongoRepository implements IRepository{
    @Override
    public void save() {
        System.out.println("save"+"to mongn");
    }
}
