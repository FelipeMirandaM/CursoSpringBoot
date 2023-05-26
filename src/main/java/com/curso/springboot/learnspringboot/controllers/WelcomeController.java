package com.curso.springboot.learnspringboot.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model){
        model.put("name",getLoggedinUsername());

        return "welcome";
    }

    private String getLoggedinUsername(){
        return SecurityContextHolder
                .getContext().getAuthentication().getName();
    }

}
