package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import static com.atmostadam.cats.api.util.CatApiUtils.convertToJsonNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationTest {
    public static final Location EXPECTED = testData();
    public static final JsonNode EXPECTED_NODE = convertToJsonNode(testData());

    public static final Location testData() {
        return new Location()
                .setCage(CageTest.EXPECTED);
    }

    @Test
    void location() {
        Location actual = new Location()
                .setCage(CageTest.EXPECTED);
        assertEquals(convertToJsonNode(actual), EXPECTED_NODE);
    }
}
