package com.atmostadam.cats.api.model;

import com.atmostadam.cats.api.exception.CatException;
import com.atmostadam.cats.api.model.in.CatMicrochipRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CatMicrochipRequestTest {
    public static final CatMicrochipRequest testData() {
        return new CatMicrochipRequest().setMicrochip(new Microchip().setMicrochipNumber(431654132132657L));
    }

    @Test
    void setMicrochip() {
        CatMicrochipRequest actual = new CatMicrochipRequest().setMicrochip(new Microchip().setMicrochipNumber(431654132132657L));
        assertThat(actual.getMicrochip().getMicrochipNumber(), Matchers.equalTo(431654132132657L));
    }

    @Test
    void setMicrochipNumber() {
        CatMicrochipRequest actual = new CatMicrochipRequest().setMicrochipNumber(431654132132657L);
        assertThat(actual.getMicrochip().getMicrochipNumber(), Matchers.equalTo(431654132132657L));
    }

    @Test
    void newCatResponse() {
        CatException actualException = new CatException("12345");
        CatResponse actual = testData().newCatResponse(actualException);

        assertThat(actual.getMessage(), Matchers.equalTo("Microchip number [431654132132657] have associated exception message [12345]"));
        assertThat(actual.getStackTrace().isEmpty(), Matchers.equalTo(false));
        assertThat(actual.getCats().isEmpty(), Matchers.equalTo(true));
    }
}
