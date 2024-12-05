package VTTPday18.inclass.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import VTTPday18.inclass.Models.Person;
import VTTPday18.inclass.Service.CarkparkService;

@Controller
@RequestMapping("/carparks")
public class CarparkController{
    
    @Autowired
    private CarkparkService carkparkService;
    

    @GetMapping("/")
    public String landingPage(Model model){
        return "index";
    }


    @GetMapping("")
    public String carparkPage(Model model){
        model.addAttribute("carparks", carkparkService.getCarparks());
        return "carparks";
    }

    
}
