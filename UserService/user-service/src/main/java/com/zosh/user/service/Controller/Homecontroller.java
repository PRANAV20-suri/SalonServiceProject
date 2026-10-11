package com.zosh.user.service.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Homecontroller {
    @GetMapping
    public String  returnname(){
        return("oController working");
    }
}
