package com.atmostadam.cats.api.configuration;

import com.atmostadam.cats.api.service.CatService;
import com.atmostadam.cats.api.service.CatSpringBeanServiceNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
@EnableConfigurationProperties(CatWebClientProperties.class)
public class CatConfiguration {
    public static final Logger logger = LoggerFactory.getLogger(CatConfiguration.class);

    @Bean(CatSpringBeanServiceNames.SERVICE_MAP)
    public Map<String, CatService> serviceMap(@Autowired ApplicationContext applicationContext) {
        Objects.requireNonNull(applicationContext);
        Map<String, CatService> serviceMap = applicationContext.getBeansOfType(CatService.class);
        if(Objects.isNull(serviceMap) || serviceMap.isEmpty()) {
            logger.warn("[WARNING] There are no implementation classes for the CatService Interface. Please correct and redeploy.");
            return Map.of();
        }
        serviceMap.forEach((k, v) -> logger.info("[SPRING BEAN DEPLOYMENT] - [Map<String, CatService>] [{}, {}]",
                k, k + ".class"));
        return serviceMap;
    }

    @Bean("CatServiceProperties")
    @ConfigurationProperties(prefix = "cats.service")
    public Properties catServiceProperties() {
        return new Properties();
    }
}
