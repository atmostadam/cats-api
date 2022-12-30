package com.atmostadam.cats.api.model;

import com.atmostadam.cats.api.entity.CatEntity;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CatTest {
    public static final long TEST_MICROCHIP_NUMBER = 431654132132657L;
    public static final String TEST_NAME = "Shelley";
    public static final String TEST_BREED = "Domestic Shorthair";
    public static final String TEST_TYPE = "Calico";
    public static final String TEST_PRIMARY_COLOR = "Orange";
    public static final String TEST_SEX = "F";
    public static final int TEST_AGE = 2;
    public static final boolean TEST_DECEASED = false;
    public static final boolean TEST_NEUTERED = true;

    public static final Cat testData() {
        return new Cat()
                .setMicrochipNumber(TEST_MICROCHIP_NUMBER)
                .setName(TEST_NAME)
                .setBreed(TEST_BREED)
                .setType(TEST_TYPE)
                .setPrimaryColor(TEST_PRIMARY_COLOR)
                .setSex(TEST_SEX)
                .setAge(TEST_AGE)
                .setDeceased(TEST_DECEASED)
                .setNeutered(TEST_NEUTERED);
    }

    public static final void assertCat(Cat cat) {
        assertThat(cat.getMicrochipNumber(), Matchers.equalTo(CatTest.TEST_MICROCHIP_NUMBER));
        assertThat(cat.getName(), Matchers.equalTo(CatTest.TEST_NAME));
        assertThat(cat.getBreed(), Matchers.equalTo(CatTest.TEST_BREED));
        assertThat(cat.getType(), Matchers.equalTo(CatTest.TEST_TYPE));
        assertThat(cat.getPrimaryColor(), Matchers.equalTo(CatTest.TEST_PRIMARY_COLOR));
        assertThat(cat.getSex(), Matchers.equalTo(CatTest.TEST_SEX));
        assertThat(cat.getAge(), Matchers.equalTo(CatTest.TEST_AGE));
        assertThat(cat.isDeceased(), Matchers.equalTo(CatTest.TEST_DECEASED));
        assertThat(cat.isNeutered(), Matchers.equalTo(CatTest.TEST_NEUTERED));
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
