package com.teamproject.smiledoor.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

    @RequestMapping("/Main")
    public String Main() throws Exception{

        return "/html/Main";
    }

    @RequestMapping("/test")
    public String test() throws Exception{

        return "/html/testMain";
    }
}
