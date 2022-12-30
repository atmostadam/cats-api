package com.atmostadam.cats.api.configuration;

import com.atmostadam.cats.api.service.CatService;
import com.atmostadam.cats.api.service.CatSpringBeanServiceNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Objects;

@Configuration
@ComponentScan(basePackages = {"com.atmostadam.cats.api.service", "com.atmostadam.cats.api.rest"})
public class CatConfiguration {
    public static final Logger logger = LoggerFactory.getLogger(CatConfiguration.class);

    @Bean(CatSpringBeanServiceNames.SERVICE_MAP)
    public Map<String, CatService> serviceMap(@Autowired ApplicationContext applicationContext) {
        logger.info(
                "[SPRING BEAN DEPLOYMENT] - [Map<String, CatService>] [serviceMap]");
        if(Objects.isNull(applicationContext)) {
            throw new NullPointerException("Spring could not load [null] ApplicationContext");
        }
        Map<String, CatService> serviceMap = applicationContext.getBeansOfType(CatService.class);
        if(serviceMap.isEmpty()) {
            throw new IllegalStateException("ApplicationContext does not contain any CatService's");
        }
        return serviceMap;
    }
}
