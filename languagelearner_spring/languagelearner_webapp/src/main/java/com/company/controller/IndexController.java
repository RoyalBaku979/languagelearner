package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(method = {RequestMethod.GET}, value="/login")//users?name=Sarkhan
    public String loginPost(){
        return "login";
    }

    @RequestMapping(method = {RequestMethod.GET}, value="/logout")//users?name=Sarkhan
    public String logoutPost(){
        return "logout";
    }

}
