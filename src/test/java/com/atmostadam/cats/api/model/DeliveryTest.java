package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.atmostadam.cats.api.util.CatApiUtilsTest.convertToJsonNode;

public class DeliveryTest {
    public static final Delivery EXPECTED = testData();
    public static final JsonNode EXPECTED_NODE = convertToJsonNode(testData());

    public static final Delivery testData() {
        return new Delivery()
                .setDeliverTo(LocationTest.EXPECTED);
    }

    @Test
    void delivery() {
        Delivery actual = new Delivery()
                .setDeliverTo(LocationTest.EXPECTED);
        assertEquals(EXPECTED_NODE, convertToJsonNode(actual));
    }
}
