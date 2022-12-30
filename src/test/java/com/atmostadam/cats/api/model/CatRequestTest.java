package com.atmostadam.cats.api.model;

import com.atmostadam.cats.api.exception.CatException;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class CatRequestTest {
    public static final Long TEST_MICROCHIP_NUMBER = 431654132132657L;
    public static final Long TEST_MICROCHIP_NUMBER_2 = 431654142132657L;
    public static final Long TEST_MICROCHIP_NUMBER_3 = 431666132132657L;
    public static final String TEST_REQUEST_ID = "d1e2a63e-7c43-47ba-8721-ab872640b0b1";

    public static final CatRequest testData() {
        return new CatRequest().addCat(CatTest.testData());
    }

    @Test
    void addMicrochipNumbers() {
        CatRequest actual = new CatRequest().addMicrochipNumbers(List.of(TEST_MICROCHIP_NUMBER,
                TEST_MICROCHIP_NUMBER_2, TEST_MICROCHIP_NUMBER_3));
        assertThat(actual.getMicrochipNumbers().size(), Matchers.equalTo(3));
    }

    @Test
    void addMicrochipNumber() {
        CatRequest actual = new CatRequest().addMicrochipNumber(TEST_MICROCHIP_NUMBER);
        assertThat(actual.getMicrochipNumbers().size(), Matchers.equalTo(1));
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
