package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import static com.atmostadam.cats.api.test.CatTestValues.*;
import static com.atmostadam.cats.api.util.CatApiUtils.convertToJsonNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CageTest {
    public static final Cage EXPECTED = testData();
    public static final JsonNode EXPECTED_NODE = convertToJsonNode(testData());

    public static final Cage testData() {
        return new Cage()
                .setId(CAGE_ID)
                .setHeight(HEIGHT)
                .setWidth(WIDTH)
                .setDepth(DEPTH)
                .setNumOfShelves(NUM_OF_SHELVES)
                .setMaxCats(MAX_CATS)
                .setBuiltInToys(BUILT_IN_TOYS)
                .setBuiltInLitterbox(BUILT_IN_LITTERBOX)
                .setBuiltInFood(BUILT_IN_FOOD)
                .setBuiltInWater(BUILT_IN_WATER)
                .setBuiltInBed(BUILT_IN_BED)
                .setConnections(CONNECTIONS);
    }

    @Test
    void cage() {
        Cage actual = new Cage()
                .setId(CAGE_ID)
                .setHeight(HEIGHT)
                .setWidth(WIDTH)
                .setDepth(DEPTH)
                .setNumOfShelves(NUM_OF_SHELVES)
                .setMaxCats(MAX_CATS)
                .setBuiltInToys(BUILT_IN_TOYS)
                .setBuiltInLitterbox(BUILT_IN_LITTERBOX)
                .setBuiltInFood(BUILT_IN_FOOD)
                .setBuiltInWater(BUILT_IN_WATER)
                .setBuiltInBed(BUILT_IN_BED)
                .setConnections(CONNECTIONS);
        assertEquals(convertToJsonNode(actual), EXPECTED_NODE);
    }
}
