package cn.yt4j.event.oo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
@Slf4j
public class EatEventPublisherAware  {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    private ApplicationEvent eatEvent;

    public EatEventPublisherAware(ApplicationEvent eatEvent) {
        this.eatEvent=eatEvent;
    }

    public void refreshEvent(){
        log.info("发送事件");
        this.applicationEventPublisher.publishEvent(this.eatEvent);
    }
}
