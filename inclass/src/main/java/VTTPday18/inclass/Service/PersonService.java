package VTTPday18.inclass.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VTTPday18.inclass.Models.Person;
import VTTPday18.inclass.Repository.ListRepo;

@Service
public class PersonService {

    @Autowired
    private ListRepo listRepo;
    
    public void createPerson(Person person){
        //Person to string
        //set string into redis
        listRepo.rightPush("persons", person.toString());
   
    }


    public List<Person> getPersonList(String redisKey){
        List<String> personString = listRepo.getList(redisKey);
        //convert personList into Person List
        List<Person> persons = new ArrayList<>();

        for (String s: personString) {
            String [] personArray = s.split(",");
            Person p = new Person(Integer.parseInt(personArray[0]), personArray[1], personArray[2], personArray[3], personArray[4]);
            persons.add(p);
        }

        return persons;
    }



}
