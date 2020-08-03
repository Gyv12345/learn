package cn.yt4j.event.oo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfig {
    @Bean
    public ApplicationEvent eatEvent() {
        return new EatEvent(true);
    }

    @Bean
    public EatEventListener eatEventListener() {
        return new EatEventListener();
    }

    @Bean
    public EatEventPublisherAware eatEventPublisherAware(ApplicationEvent eatEvent) {
        return new EatEventPublisherAware(eatEvent);
    }

}
