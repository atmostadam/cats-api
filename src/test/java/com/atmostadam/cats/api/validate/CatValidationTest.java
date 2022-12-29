package com.atmostadam.cats.api.validate;

import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.test.CatTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;

class  CatValidationTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void queryByMicrochipNumberLessThan9Digits() {
        Cat cat = CatTest.testData();
        cat.setMicrochipNumber(43L);
        Set<ConstraintViolation<Cat>> violations = validator.validate(cat);
        System.out.println(violations);
        assertThat(violations.size(), Matchers.equalTo(1));
        assertThat(violations.stream().findFirst().get().getMessage(),
                Matchers.equalTo("Microchip Number must 9 digits or greater based on manufacturer standards."));
    }
}
