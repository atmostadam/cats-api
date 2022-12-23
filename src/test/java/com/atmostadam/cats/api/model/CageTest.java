package com.atmostadam.cats.api.model;

import com.atmostadam.cats.api.model.in.CatRequest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author Adam Johnston, Rachel Johnston
 */
class CageTest {
    public static Cage testData() {
        Cage cage = new Cage();
        cage.setId("Cage-3");
        cage.setBuiltInLitterbox(true);
        cage.setNumOfShelves(4);
        cage.setBuiltInFood(true);
        cage.setBuiltInWater(true);
        cage.setBuiltInBed(true);
        return cage;
    }
}
