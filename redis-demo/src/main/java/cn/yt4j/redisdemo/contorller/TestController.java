package cn.yt4j.redisdemo.contorller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description:
 * @Author: shichenyang
 * @Company: 河南云数谷科技有限公司
 * @Date: 2020/7/14 15:36
 * @Version: @Version: V1.0
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private RedissonClient redisson;

    @GetMapping("/{id}")
    public String test(@PathVariable String id) {
        RLock lock = redisson.getLock(id);
        System.out.println(Thread.currentThread().getName() + ":" + id);

        if (lock.tryLock()) {
            System.out.println(Thread.currentThread().getName() + "我有锁");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            return "成功";
        }

        return "失败";
    }
}
