package com.escvoting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permet les requêtes sur toutes les URL de l'API
                .allowedOrigins("http://localhost:4200") // Remplacez par le port de votre front-end (ex: 3000 pour React)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permet ces méthodes HTTP
                .allowedHeaders("*") // Permet tous les en-têtes
                .allowCredentials(true); // Permet l'envoi de cookies, en-têtes d'autorisation, etc.
    }
}