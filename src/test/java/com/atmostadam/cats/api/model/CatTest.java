package com.atmostadam.cats.api.model;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CatTest {
    public static Cat testData() {
        return new Cat()
                .setMicrochipNumber(431654132132657L)
                .setName("Shelley")
                .setBreed("Domestic Shorthair")
                .setType("Calico")
                .setPrimaryColor("Orange")
                .setSex("F")
                .setAge(2)
                .setDeceased(false)
                .setNeutered(true);
    }

    @Test
    void setMicrochip() {
        Cat actual = new Cat().setMicrochip(new Microchip().setMicrochipNumber(431654132132657L));
        assertThat(actual.getMicrochip().getMicrochipNumber(), Matchers.equalTo(431654132132657L));
    }

    @Test
    void setMicrochipNumber() {
        Cat actual = new Cat().setMicrochipNumber(431654132132657L);
        assertThat(actual.getMicrochip().getMicrochipNumber(), Matchers.equalTo(431654132132657L));
    }
}
