package com.platzi_play;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final PlatziPlayAIService aiService;

    public HelloController(PlatziPlayAIService aiService){
        this.aiService = aiService;
    }

    @GetMapping ("/") /// Peticiones de tipo 'get' son para obtener info
    public String hello(){
        return this.aiService.generateGreeting();
    }

}
