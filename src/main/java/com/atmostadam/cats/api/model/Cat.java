package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

/** A JSON object that represents the actual cat itself. */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cat {
    /** Worldwide 9 to 15 digit number unique identifier for a chip that goes into the back of a pet's neck. */
    @Min(value = 100000000L, message = "Microchip Number must 9 digits or greater based on manufacturer standards.")
    @Max(value = 999999999999999L, message = "Microchip Number must 15 digits or less based on manufacturer standards.")
    private Long microchipNumber;

    @NotBlank(message = "Cat must have a name.")
    private String name;

    private String breed;

    private String type;

    private String primaryColor;

    @Pattern(regexp = "[mfMF]", message = "Cat must have a sex.")
    private String sex;

    @Max(value = 38, message = "Cat must be between 0 and 38 years old.")
    private int age;

    private boolean neutered;

    private boolean deceased;
}
