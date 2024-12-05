package VTTPday18.inclass.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ListRepo {
    @Autowired @Qualifier("redis-0")
    RedisTemplate<String, String> redisTemplate;

    //lpush {redisKey} {value}
    //adding to array from the top
    public void leftPush(String redisKey, String value){
        redisTemplate.opsForList().leftPush(redisKey, value);
    }
    
    //rpush {redisKey} {value}
    //adding to array from the bottom
    public void rightPush(String redisKey, String value){
        redisTemplate.opsForList().rightPush(redisKey, value);
    }

    //lpop {redisKey}
    //removing from array from the top, that element can be returned to service if we choose
    public void leftPop(String redisKey){
        redisTemplate.opsForList().leftPop(redisKey);
    }
    
    //rpop {redisKey}
    //removing from array from the bottom, that element can be returned to service if we choose
    public void rightPop(String redisKey){
        redisTemplate.opsForList().rightPop(redisKey);
    }

    //llen {redisKey}
    //get size of list
    public Long size(String redisKey){
        return redisTemplate.opsForList().size(redisKey);
    }

    //lindex {redisKey} {index}
    //get element at specific index
    public String get(String redisKey, int index){
        return redisTemplate.opsForList().index(redisKey, index);
    }

    //lrange {redisKey} 0 -1
    //-1 retrieves everything
    public List<String> getList(String redisKey){
        return redisTemplate.opsForList().range(redisKey, 0, -1);
    }

}
