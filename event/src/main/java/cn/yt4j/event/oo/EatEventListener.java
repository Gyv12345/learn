package cn.yt4j.event.oo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

@Slf4j
public class EatEventListener  {

    @EventListener()
    public void onApplicationEvent(EatEvent event) {
        if (event.isEatFinished()){
            event.callGirlFriend();
            log.error("来自母老虎的咆哮：滚犊子");
            event.callBrothers();
            log.error("太晚了，我们已经满了，明天带你");
            log.info("还是关注一下 【码农小胖哥】 学习点新知识吧");
        }
    }
}
