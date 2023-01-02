package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.atmostadam.cats.api.util.CatApiUtils.convertToJsonNode;
import static com.atmostadam.cats.api.util.CatDefaultValues.*;
import static com.atmostadam.cats.api.util.CatDefaultValues.TEST_MAX_CATS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CageTest {
    public static final Cage EXPECTED = testData();
    public static final JsonNode EXPECTED_NODE = convertToJsonNode(testData());

    public static final Cage testData() {
        return new Cage()
                .setId(TEST_CAGE_ID)
                .setHeight(TEST_HEIGHT)
                .setWidth(TEST_WIDTH)
                .setDepth(TEST_DEPTH)
                .setNumOfShelves(TEST_NUM_OF_SHELVES)
                .setMaxCats(TEST_MAX_CATS)
                .setBuiltInToys(TEST_BUILT_IN_TOYS)
                .setBuiltInLitterbox(TEST_BUILT_IN_LITTERBOX)
                .setBuiltInFood(TEST_BUILT_IN_FOOD)
                .setBuiltInWater(TEST_BUILT_IN_WATER)
                .setBuiltInBed(TEST_BUILT_IN_BED)
                .setConnections(List.of());
    }

    @Test
    void cage() {
        Cage actual = new Cage()
                .setId(TEST_CAGE_ID)
                .setHeight(TEST_HEIGHT)
                .setWidth(TEST_WIDTH)
                .setDepth(TEST_DEPTH)
                .setNumOfShelves(TEST_NUM_OF_SHELVES)
                .setMaxCats(TEST_MAX_CATS)
                .setBuiltInToys(TEST_BUILT_IN_TOYS)
                .setBuiltInLitterbox(TEST_BUILT_IN_LITTERBOX)
                .setBuiltInFood(TEST_BUILT_IN_FOOD)
                .setBuiltInWater(TEST_BUILT_IN_WATER)
                .setBuiltInBed(TEST_BUILT_IN_BED)
                .setConnections(List.of());
        assertEquals(EXPECTED_NODE, convertToJsonNode(actual));
    }
}
