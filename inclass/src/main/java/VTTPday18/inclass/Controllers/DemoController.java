package VTTPday18.inclass.Controllers;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import VTTPday18.inclass.Models.Person;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired @Qualifier("redis-0")
    RedisTemplate redisTemplate;

    
    @GetMapping("/health")
    public ModelAndView getHealth(){
        
        ModelAndView mav = new ModelAndView();

        try{

            checkHealth();
            mav.setViewName("healthy");
            mav.setStatus(HttpStatusCode.valueOf(200));

        } catch(Exception ex){
            mav.setViewName("unhealthy");
            mav.setStatus(HttpStatusCode.valueOf(500));
        }
        return mav;
    }


    private void checkHealth() throws Exception{
        Random rand = new SecureRandom();

        Integer number = rand.nextInt(10);

        if(number <= 5){
            throw new Exception("Simulating error .... " + number.toString());
        }

    }

    @GetMapping("/time")
    public String displayDateTime(Model model) throws ParseException{

        // yyyy-MM-dd HH:mm:ss 1980-07-25 15:30:40
        // yyyy-MMM-dd HH:mm:ss 1980-JUL-25 15:30:40
        // yyyy-MMM-dd hh`:mm:ss a 1980-JUL-25 3:30:40 PM
        String strDate = "1980-07-25 15:30:40";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //turn string into Date obj
        Date demoDate = sdf.parse(strDate);

        //when storing DT in db, store as LONG integer
        //casting Date object to long and back
        long epochMilliseconds = demoDate.getTime();
        Date retrievedDate = new Date(epochMilliseconds);


        //data parsed to thymeleaf vieew must be a Date object
        model.addAttribute("date", retrievedDate);
        return "time";
    }



    @GetMapping("/test")
    public List<String> testHash(){

        List<String> wordList  = new ArrayList<>();
        wordList.add("Marina");
        wordList.add("Park");
        wordList.add("Bridge");
        wordList.add("Merlion");


        //save the list to hash in redis
        redisTemplate.opsForHash().put("words", "map", wordList.toString());

        //retrieve the list from redis
        Object objWords = redisTemplate.opsForHash().get("words", "map");

        String strObject = objWords.toString();
        strObject = strObject.replace("[", "");
        strObject = strObject.replace("]", "");
        strObject = strObject.replace(" ", "");
        String [] splitWord = strObject.split(",");
        List<String> retrievedLst = new ArrayList<>();

        for(String s:splitWord){
            retrievedLst.add(s);
        }
        return retrievedLst;

    }

    public String testPersonsList(){
        List<Person> personsList = new ArrayList<>();
        Person p = new Person(1, "Darryl", "daryyl@nus.edu.sg", "530363", "99445566");
        personsList.add(p);
        p = new Person(1, "Samuel", "samuel@gmail.com", "530363", "99445566");
        personsList.add(p);


        //use day 17 version instead
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        for(Person pp: personsList){
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("id", pp.getId());
            jsonObjectBuilder.add("id", pp.getFullName());
            jsonObjectBuilder.add("id", pp.getEmail());
            jsonObjectBuilder.add("id", pp.getPostalCode());
            jsonObjectBuilder.add("id", pp.getPhoneNumber());
            jsonObjectBuilder.build();
            jsonArrayBuilder.add(jsonArrayBuilder);
        }
        jsonArrayBuilder.build();

        //save the list to hash in redis (proper way to serialize)
        redisTemplate.opsForHash().put("persons", p.getId(), jsonArrayBuilder.toString());


        //save the list to hash in redis, as a singular string
        //Person toString method is using comma seperated version
        redisTemplate.opsForHash().put("persons", "map", personsList.toString());

        //retrieve the ist from redis
        Object objWords = redisTemplate.opsForHash().get("persons", "map");


        return objWords.toString();

    }



}
