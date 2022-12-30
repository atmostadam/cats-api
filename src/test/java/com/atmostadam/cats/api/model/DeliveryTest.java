package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import static com.atmostadam.cats.api.util.CatApiUtils.convertToJsonNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(convertToJsonNode(actual), EXPECTED_NODE);
    }
}
