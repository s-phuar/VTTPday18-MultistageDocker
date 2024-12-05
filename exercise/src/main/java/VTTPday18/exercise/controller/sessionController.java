package VTTPday18.exercise.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import VTTPday18.exercise.model.User;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping
public class sessionController {
    
    @GetMapping("/create")
    public String createUser(Model model){
        User user = new User();

        model.addAttribute("user", user);

        return "creation-page";
    }


    @PostMapping("/display")
    public String displayUser(@ModelAttribute("user") User user, HttpSession sess, Model model){

        if((List<User>)sess.getAttribute("userList") == null){
            List<User> userList = new ArrayList<>();
            sess.setAttribute("userList", userList);
        }

        List<User> userList = (List<User>)sess.getAttribute("userList");

        if(user.getName() == null){
        }else{
            userList.add(user);
        }

        sess.setAttribute("userList", userList);

        //debugging
        System.out.println(userList);

        model.addAttribute("userList", userList);

        return "display-user";
    }


    @GetMapping("/clear")
    public String clearUser(HttpSession sess){
        sess.invalidate();
        
        return "index.html";
    }



}
