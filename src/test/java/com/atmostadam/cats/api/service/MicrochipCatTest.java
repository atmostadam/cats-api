package com.atmostadam.cats.api.service;

import com.atmostadam.cats.api.configuration.CatConfiguration;
import com.atmostadam.cats.api.configuration.CatConfigurationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Service(CatSpringBeanServiceNames.MICROCHIP_CAT)
@SpringJUnitConfig(CatConfigurationTest.class)
class MicrochipCatTest extends CatServiceTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    void validateInjection() {
        // Test Injection for Sonarqube.
        assertTrue(applicationContext.containsBean(CatSpringBeanServiceNames.MICROCHIP_CAT));
    }
}
