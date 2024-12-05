package VTTPday18.inclass.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MapRepo {
    
    @Autowired @Qualifier("redis-object")
    RedisTemplate redisTemplate;


    //hset {key} {hashKey} {value}
    public void createHash(String key, String hashKey, Object value){
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    //slide 37
    //hget {key} {hashKey}
    public Object get(String key, String hashKey){
        Object objValue = redisTemplate.opsForHash().get(key, hashKey);
        return objValue.toString();
    }
    //slide 38
    //hdel {key} {hashKey}
    public void delete(String key, String hashKey){
        redisTemplate.opsForHash().delete(key, hashKey);
    }
    //slide 39
    //hexists {key} {hashKey}
    public boolean hashKeyExists(String key, String hashKey){
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    //slide 40
    //hkeys {key}
    //get all keys from Map
    public Set<String> getKeys(String key){
        return redisTemplate.opsForHash().keys(key);
    }

    //hvals {key}
    //get all values from Map
    public List<Object> getValues (String key){
        return redisTemplate.opsForHash().values(key);
    }

    //slide 41
    //hlen {key}
    public Long size(String key){
        return redisTemplate.opsForHash().size(key);
    }

    //hincrby {key} {hashKey} 1
    public Long incrValue(String key, String hashKey){
        return redisTemplate.opsForHash().increment(key, hashKey, 1);
    }



}
