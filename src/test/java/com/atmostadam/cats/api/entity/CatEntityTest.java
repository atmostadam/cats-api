package com.atmostadam.cats.api.entity;

import com.atmostadam.cats.api.model.Cat;
import lombok.NonNull;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CatEntityTest {
    public static final CatEntity testData() {
        return new CatEntity()
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
    void newCat() {
        Cat cat = testData().newCat();
        assertThat(cat.getMicrochip().getMicrochipNumber(), Matchers.equalTo(431654132132657L));
        assertThat(cat.getName(), Matchers.equalTo("Shelley"));
        assertThat(cat.getBreed(), Matchers.equalTo("Domestic Shorthair"));
        assertThat(cat.getType(), Matchers.equalTo("Calico"));
        assertThat(cat.getPrimaryColor(), Matchers.equalTo("Orange"));
        assertThat(cat.getSex(), Matchers.equalTo("F"));
        assertThat(cat.getAge(), Matchers.equalTo(2));
        assertThat(cat.isDeceased(), Matchers.equalTo(false));
        assertThat(cat.isNeutered(), Matchers.equalTo(true));
    }
}
