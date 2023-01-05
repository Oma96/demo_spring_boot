package com.example.demospringboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // pour retourner une page html, on utilise controller
public class DemoController {
    @GetMapping("hello")
    @ResponseBody // remplir le body de la réponse HTTP ce que retourne cette méthode
    public String sayHello(){
        return "<h1>Hello</h1>";
    }

}
