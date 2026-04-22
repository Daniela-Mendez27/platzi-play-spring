package com.platzi_play;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService // La anotación debe ir aquí arriba
public interface PlatziPlayAIService {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de Gestión de Películas PlatziPlay.
            Usa menos de 120 caracteres y hazlo con el estilo de Platzi.
            """)
    String generateGreeting();
}