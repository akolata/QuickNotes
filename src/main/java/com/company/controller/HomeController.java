package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "/home"})
public class HomeController {

    private static final String HOME_PAGE_NAME = "index";

    @GetMapping
    public String showHomePage(){
        return HOME_PAGE_NAME;
    }
}
