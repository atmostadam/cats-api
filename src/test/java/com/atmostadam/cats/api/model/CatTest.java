package com.atmostadam.cats.api.model;

import com.atmostadam.cats.api.entity.CatEntity;
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

    @Test
    void newCatEntity() {
        CatEntity cat = testData().newCatEntity();
        assertThat(cat.getMicrochipNumber(), Matchers.equalTo(431654132132657L));
        assertThat(cat.getName(), Matchers.equalTo("Shelley"));
        assertThat(cat.getBreed(), Matchers.equalTo("Domestic Shorthair"));
        assertThat(cat.getType(), Matchers.equalTo("Calico"));
        assertThat(cat.getPrimaryColor(), Matchers.equalTo("Orange"));
        assertThat(cat.getSex(), Matchers.equalTo("F"));
        assertThat(cat.getAge(), Matchers.equalTo(2));
        assertThat(cat.getDeceased(), Matchers.equalTo(false));
        assertThat(cat.getNeutered(), Matchers.equalTo(true));
    }
}
