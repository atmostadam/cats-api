package com.atmostadam.cats.api.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class CageTest {
    @Test
    void catCage() {
        Cage rachelsCage = new Cage();
        rachelsCage.setId("Cage-3");
        rachelsCage.setBuiltInLitterbox(true);
        rachelsCage.setNumOfShelves(4);
        rachelsCage.setBuiltInFood(true);
        rachelsCage.setBuiltInWater(true);
        rachelsCage.setBuiltInBed(true);

        assertThat(rachelsCage.getId(), equalTo("Cage-3"));
    }
}
