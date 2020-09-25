package cn.yt4j.fanpin.controller;

import cn.yt4j.fanpin.entity.User;
import cn.yt4j.fanpin.resposity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("fanpin")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("{id}")
    public Mono<User> get(@PathVariable String id){
        return userRepository.getById(id);
    }

    @PostMapping
    public Mono<User> insert(@RequestBody User user){
        return userRepository.insert(user);
    }

    @GetMapping("all")
    public Flux<User> list(){
        return userRepository.findAll();
    }


}
