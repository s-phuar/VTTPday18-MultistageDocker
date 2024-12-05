package VTTPday18.inclass.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ValueRepo {
    @Autowired @Qualifier("redis-0")
    RedisTemplate<String, String> redisTemplate;


    //set {redisKey} {value}
    public void setValue(String redisKey, String value){
        redisTemplate.opsForValue().set(redisKey, value);
    }

    //get {redisKey}
    public String getValue(String redisKey, String value){
        return redisTemplate.opsForValue().get(redisKey);
    }

    //incr {redisKey}
    public void incrementValue(String redisKey){
        redisTemplate.opsForValue().increment(redisKey);
    }

    //decr {redisKey}
    public void decrementValue(String redisKey){
        redisTemplate.opsForValue().decrement(redisKey);
    }

    //incrby {redisKey} {valueToIncr}
    public void incrementValue(String redisKey, int valueToIncr){
        redisTemplate.opsForValue().increment(redisKey, valueToIncr);
    }

    //decrby {redisKey} {valueToIncr}
    public void decrementValue(String redisKey, int valueToDcr){
        redisTemplate.opsForValue().decrement(redisKey, valueToDcr);
    }

    //del {redisKey}
    public void deleteKey(String redisKey){
        redisTemplate.delete(redisKey);
    }

    //exists {redisKey}
    public boolean checkKeyExists(String redisKey){
        return redisTemplate.hasKey(redisKey);
    }


    


}
