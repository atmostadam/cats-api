package com.atmostadam.cats.api;


import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.List;

class CatRequestTest {
    Faker faker = Faker.instance();

    @Test
    void microchipNumberLessThan9() {
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
