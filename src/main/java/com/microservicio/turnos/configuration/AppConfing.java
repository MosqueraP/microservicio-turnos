package com.microservicio.turnos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfing {

    @Bean("apiConsumir") // alias del template
    public RestTemplate registrarRestTemplate() {
        return new RestTemplate();
    }
}
