package com.platzi_play.web.controller;


import com.platzi_play.domain.service.PlatziPlayAIService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final String plataforma;


    private final PlatziPlayAIService aiService;

    public HelloController(@Value("${spring.application.name}") String plataforma, PlatziPlayAIService aiService){
        this.plataforma = plataforma;
        this.aiService = aiService;
    }

    @GetMapping ("/hello") /// Peticiones de tipo 'get' son para obtener info
    public String hello(){
        return this.aiService.generateGreeting(plataforma);
    }

}
