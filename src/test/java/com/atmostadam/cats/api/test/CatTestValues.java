package com.atmostadam.cats.api.test;

import com.atmostadam.cats.api.model.Cage;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class CatTestValues {
    private CatTestValues() {}

    public static final String ADOPT_ID = UUID.randomUUID().toString();
    public static final String FIRST_NAME = "TEST FIRST NAME";
    public static final String LAST_NAME = "TEST LAST NAME";
    public static final String BUSINESS_NAME = "TEST BUSINESS NAME";
    public static final String CAGE_ID = "CAGE-1";
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
    public static final String TEST_NAME = "Shelley";
    public static final String TEST_BREED = "Domestic Shorthair";
    public static final String TEST_TYPE = "Calico";
    public static final String TEST_PRIMARY_COLOR = "Orange";
    public static final String TEST_SEX = "F";
    public static final int TEST_AGE = 2;
    public static final boolean TEST_DECEASED = false;
    public static final boolean TEST_NEUTERED = true;
    public static final Long TEST_MICROCHIP_NUMBER = 431654132132657L;
    public static final Long TEST_MICROCHIP_NUMBER_2 = 431654142132657L;
    public static final Long TEST_MICROCHIP_NUMBER_3 = 431666132132657L;
    public static final String TEST_REQUEST_ID = "d1e2a63e-7c43-47ba-8721-ab872640b0b1";
    public static final String TEST_MESSAGE = "TEST MESSAGE";
    public static final String TEST_STACK_TRACE = ExceptionUtils.getStackTrace(new RuntimeException(TEST_MESSAGE));
}
