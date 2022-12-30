package com.atmostadam.cats.api.model;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class CageTest {
    public static final Cage EXPECTED = testData();
    public static final String ID = "CAGE-1";
    public static final int HEIGHT = 1;
    public static final int WIDTH = 1;
    public static final int DEPTH = 1;
    public static final int NUM_OF_SHELVES = 1;
    public static final int MAX_CATS = 1;
    public static final boolean BUILT_IN_TOYS = true;
    public static final boolean BUILT_IN_LITTERBOX = true;
    public static final boolean BUILT_IN_FOOD = true;
    public static final boolean BUILT_IN_WATER = true;
    public static final boolean BUILT_IN_BED = true;
    public static final List<Cage> CONNECTIONS = new ArrayList<>();


    public static final Cage testData() {
        return new Cage()
                .setId(ID)
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

    //@Test
    void cage() {
        Cage actual = new Cage()
                .setId(ID)
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
        assertCage(actual, EXPECTED);
    }

    public static final void assertCage(Cage actual, Cage expected) {
        assertThat(actual.getId(), Matchers.equalTo(expected.getId()));
        assertThat(actual.getHeight(), Matchers.equalTo(expected.getHeight()));
        assertThat(actual.getWidth(), Matchers.equalTo(expected.getWidth()));
        assertThat(actual.getDepth(), Matchers.equalTo(expected.getDepth()));
        assertThat(actual.getNumOfShelves(), Matchers.equalTo(expected.getNumOfShelves()));
        assertThat(actual.getMaxCats(), Matchers.equalTo(expected.getMaxCats()));
        assertThat(actual.isBuiltInToys(), Matchers.equalTo(expected.isBuiltInToys()));
        assertThat(actual.isBuiltInLitterbox(), Matchers.equalTo(expected.isBuiltInLitterbox()));
        assertThat(actual.isBuiltInFood(), Matchers.equalTo(expected.isBuiltInFood()));
        assertThat(actual.isBuiltInWater(), Matchers.equalTo(expected.isBuiltInWater()));
        assertThat(actual.isBuiltInBed(), Matchers.equalTo(expected.isBuiltInBed()));
        assertThat(actual.getConnections(), Matchers.equalTo(expected.getConnections()));
    }
}
