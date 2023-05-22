package com.curso.springboot.learnspringboot.services.impl;

import com.curso.springboot.learnspringboot.services.IAuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {
    @Override
    public boolean authenticate(String user, String password) {


        return user.equalsIgnoreCase("test") && password.equals("123");
    }
}
