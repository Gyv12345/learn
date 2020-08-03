package cn.yt4j.test;

import cn.yt4j.event.oo.EatEventPublisherAware;
import cn.yt4j.event.oo.EventConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {EventConfig.class})
public class EventSpringApplicationTests {
    @Autowired
    private EatEventPublisherAware eatEventPublisherAware;
    @Test
    public void contextLoads() {

        eatEventPublisherAware.refreshEvent();
    }

}