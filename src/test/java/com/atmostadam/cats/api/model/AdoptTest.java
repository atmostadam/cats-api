package com.atmostadam.cats.api.model;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;


// TODO: Needs work

public class AdoptTest {
    public static final Adopt EXPECTED = testData();
    public static final Cat ADOPTED = CatTest.testData();
    public static final Person ADOPTED_TO = null;
    public static final Organization ADOPTED_FROM = null;

    public static final Adopt testData() {
        return new Adopt()
                .setAdopted(ADOPTED)
                .setAdoptTo(ADOPTED_TO)
                .setAdoptFrom(ADOPTED_FROM);
    }

    //@Test
    void adopt() {
        Adopt actual = new Adopt()
                .setAdopted(ADOPTED)
                .setAdoptTo(ADOPTED_TO)
                .setAdoptFrom(ADOPTED_FROM);
        assertAdopt(actual, EXPECTED);
    }

    public static void assertAdopt(Adopt actual, Adopt expected) {
        assertThat(actual.getAdopted(), Matchers.equalTo(expected.getAdopted()));
        assertThat(actual.getAdoptTo(), Matchers.equalTo(expected.getAdoptTo()));
        assertThat(actual.getAdoptFrom(), Matchers.equalTo(expected.getAdoptFrom()));

    }
}
