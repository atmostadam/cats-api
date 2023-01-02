package com.atmostadam.cats.api.util;

import org.junit.jupiter.api.Test;

import static com.atmostadam.cats.api.util.CatApiUtils.catEquals;
import static com.atmostadam.cats.api.util.CatApiUtils.convertToJsonNode;
import static com.atmostadam.cats.api.util.CatDefaultValues.catResponseTestData;

public class CatApiUtilsTest {
    @Test
    void catEqualsCatResponse() {
        catEquals(catResponseTestData(), catResponseTestData());
    }

    @Test
    void catEqualsJsonNode() {
        catEquals(convertToJsonNode(catResponseTestData()), convertToJsonNode(catResponseTestData()));
    }
}
