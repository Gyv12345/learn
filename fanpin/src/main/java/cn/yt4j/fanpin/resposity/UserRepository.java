package cn.yt4j.fanpin.resposity;

import cn.yt4j.fanpin.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * @author lenovo
 */
public interface UserRepository extends ReactiveMongoRepository<User,String> {
    /**
     * 查询
     * @param id
     * @return
     */
    Mono<User> getById(String id);
}
