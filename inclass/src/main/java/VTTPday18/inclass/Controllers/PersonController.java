package VTTPday18.inclass.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import VTTPday18.inclass.Models.Person;
import VTTPday18.inclass.Service.CarkparkService;
import VTTPday18.inclass.Service.PersonService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class PersonController{
    
    @Autowired
    private PersonService personService;
    

    @GetMapping("/")
    public String landingPage(Model model){
        Person person = new Person(0, null, null, null, null);
        model.addAttribute("person", person);
        return "index";
    }

    @PostMapping("/person")
    public String getPerson(@Valid @ModelAttribute("person") Person person, //person variable refers to the index.html object
        BindingResult binding){

            if (binding.hasErrors()){
                return "index";
            }
            System.out.println(person);
            personService.createPerson(person);
    
            return "redirect:/person/listing";
    }


    @GetMapping("/person/listing")
    public String personListing(Model model){
        List<Person> persons = personService.getPersonList("persons");
        //call service
        System.out.println(persons);
        model.addAttribute("persons", persons);

        return "person-listing";
    }

    
}
