package me.pedrokaua.narutoapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Home {

    @GetMapping
    public String welcome(){
        return "Welcome to NarutoAPI";
    };

    @GetMapping("/api")
    public String apiMessage(){
        return "Naruto API is an API developed by Pedro Kawan, anime fan!";
    }
}
