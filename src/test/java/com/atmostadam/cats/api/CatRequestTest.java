package com.atmostadam.cats.api;


import com.atmostadam.cats.api.model.in.CatRequest;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;

class CatRequestTest {
    Faker faker = Faker.instance();

    @Test
    void microchipNumberLessThan9() {
        CatRequest request = new CatRequest();
        request.setMicrochipNumber(new SecureRandom().nextLong(9,15));
        request.setName(faker.cat().name());
        request.setBreed(faker.cat().breed());
        request.setType("Calico");
        request.setPrimaryColor("Orange");
        request.setSex("M");
        request.setAge(new SecureRandom().nextInt(0, 2));
        request.setDeceased(false);
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
