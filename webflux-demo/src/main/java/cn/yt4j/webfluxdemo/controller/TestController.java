package cn.yt4j.webfluxdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public Mono<Map<String, String>> test() {
        return Mono.just(new HashMap<String, String>() {{
            put("a", "b");
        }});
    }
}
