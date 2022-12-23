package com.atmostadam.cats.api.model;

import com.atmostadam.cats.api.exception.CatException;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class CatRequestTest {
    public static CatRequest testData() {
        return new CatRequest().addCat(CatTest.testData());
    }

    @Test
    void addCats() {
        CatRequest actual = new CatRequest().addCats(List.of(CatTest.testData(),
                CatTest.testData(), CatTest.testData()));
        assertThat(actual.getCats().size(), Matchers.equalTo(3));
    }

    @Test
    void addCat() {
        CatRequest actual = new CatRequest().addCat(CatTest.testData());
        assertThat(actual.getCats().size(), Matchers.equalTo(1));
    }

    @Test
    void newCatResponse() {
        CatException actualException = new CatException("12345");
        CatResponse actual = testData().newCatResponse(actualException);

        assertThat(actual.getMessage(), Matchers.equalTo("Microchip numbers [431654132132657] have associated exception message [12345]"));
        assertThat(actual.getStackTrace().isEmpty(), Matchers.equalTo(false));
        assertThat(actual.getCats().size(), Matchers.equalTo(1));
    }

    @Test
    void newCatResponseMultipleCats() {
        CatException actualException = new CatException("12345");
        CatResponse actual = new CatRequest().addCat(CatTest.testData()).addCats(List.of(CatTest.testData(),
                CatTest.testData(), CatTest.testData())).newCatResponse(actualException);

        assertThat(actual.getMessage(), Matchers.equalTo("Microchip numbers [431654132132657,431654132132657,431654132132657,431654132132657] have associated exception message [12345]"));
        assertThat(actual.getStackTrace().isEmpty(), Matchers.equalTo(false));
        assertThat(actual.getCats().size(), Matchers.equalTo(4));
    }
}
