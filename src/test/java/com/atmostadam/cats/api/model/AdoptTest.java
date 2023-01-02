package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import static com.atmostadam.cats.api.util.CatApiUtils.convertToJsonNode;
import static com.atmostadam.cats.api.util.CatDefaultValues.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdoptTest {
    public static final Adopt EXPECTED = testData();
    public static final JsonNode EXPECTED_NODE = convertToJsonNode(testData());

    public static final Adopt testData() {
        return new Adopt()
                .setId(TEST_ADOPT_ID)
                .setFirstName(TEST_FIRST_NAME)
                .setLastName(TEST_LAST_NAME)
                .setBusinessName(TEST_BUSINESS_NAME);
    }

    @Test
    void adopt() {
        Adopt actual = new Adopt()
                .setId(TEST_ADOPT_ID)
                .setFirstName(TEST_FIRST_NAME)
                .setLastName(TEST_LAST_NAME)
                .setBusinessName(TEST_BUSINESS_NAME);
        assertEquals(EXPECTED_NODE, convertToJsonNode(actual));
    }
}
