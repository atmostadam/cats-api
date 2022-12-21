package com.atmostadam.cats.api.validate;

import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.Microchip;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static com.atmostadam.cats.api.test.CatTestData.cat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class  CatValidationTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void queryByMicrochipNumberLessThan9Digits() {
        Cat cat = cat();
        cat.setMicrochip(new Microchip().microchipNumber(43L));
        Set<ConstraintViolation<Cat>> violations = validator.validate(cat);
        System.out.println(violations);
        assertThat(violations.size(), Matchers.equalTo(1));
        assertThat(violations.stream().findFirst().get().getMessage(),
                Matchers.equalTo("Microchip Number must 9 digits or greater based on manufacturer standards."));
    }
}
