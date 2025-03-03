package com.atmostadam.cats.api.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import(CatConfiguration.class)
@ComponentScan("com.atmostadam.cats")
@TestConfiguration
public class CatConfigurationTest {
    @Bean("CatWebClientPropertiesPetfinder")
    @ConfigurationProperties(prefix = "cats.service.http.webclient.petfinder")
    public CatWebClientProperties catWebClientPropertiesPetfinder() {
        return new CatWebClientProperties();
    }
}
