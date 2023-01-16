package com.atmostadam.cats.api.model;

import com.atmostadam.cats.api.entity.CatEntity;
import com.fasterxml.jackson.databind.JsonNode;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static com.atmostadam.cats.api.test.CatDefaultValues.*;
import static com.atmostadam.cats.api.util.CatApiUtilsTest.convertToJsonNode;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatTest {
    public static final Cat EXPECTED = testData();
    public static final JsonNode EXPECTED_NODE = convertToJsonNode(testData());

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

    @Test
    void cat() {
        Cat actual = new Cat()
                .setMicrochipNumber(TEST_MICROCHIP_NUMBER)
                .setName(TEST_NAME)
                .setBreed(TEST_BREED)
                .setType(TEST_TYPE)
                .setPrimaryColor(TEST_PRIMARY_COLOR)
                .setSex(TEST_SEX)
                .setAge(TEST_AGE)
                .setDeceased(TEST_DECEASED)
                .setNeutered(TEST_NEUTERED);
        assertEquals(EXPECTED_NODE, convertToJsonNode(actual));
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
