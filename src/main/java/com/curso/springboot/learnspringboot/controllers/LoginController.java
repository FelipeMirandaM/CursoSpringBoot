package com.curso.springboot.learnspringboot.controllers;


import com.curso.springboot.learnspringboot.services.IAuthenticationService;
import com.curso.springboot.learnspringboot.services.impl.AuthenticationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private AuthenticationServiceImpl authenticationService;


    public LoginController(AuthenticationServiceImpl authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap map){

        if(authenticationService.authenticate(name,password)){

            return "welcome";
        }
        map.put("errorMessage","invalid Credentials! Please try again");
        return "login";

    }
}
