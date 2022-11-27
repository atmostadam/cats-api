package com.atmostadam.cats.api.model.in;


import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.rest.CatResource;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.test.web.servlet.MockMvc;

import java.security.SecureRandom;
import java.util.List;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@MockitoSettings
class CatRequestTest {
    Faker faker = Faker.instance();

    @Mock
    CatResource restResource;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = standaloneSetup(restResource).build();
    }

    @Test
    void oneCat() {
        CatRequest request = new CatRequest();
        Cat cat = new Cat();
        cat.setMicrochipNumber(new SecureRandom().nextLong(9,15));
        cat.setName(faker.cat().name());
        cat.setBreed(faker.cat().breed());
        cat.setType("Calico");
        cat.setPrimaryColor("Orange");
        cat.setSex("M");
        cat.setAge(new SecureRandom().nextInt(0, 2));
        cat.setDeceased(false);
        cat.setNeutered(true);
        request.setCats(List.of(cat));
    }

    @Test
    void microchipNumberGreaterThan15() {

    }

    @Test
    void nameIsBlank() {

    }

    @Test
    void invalidSex() {

    }


    @Test
    void ageGreaterThan2() {

    }
}
