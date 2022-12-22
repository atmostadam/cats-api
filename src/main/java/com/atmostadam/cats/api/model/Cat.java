package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * A JSON object that represents the actual cat itself.
 *
 * @author Adam Johnston, Rachel Johnston
 */
@Getter
@Setter
@Accessors(fluent = false, chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cat {
    @Valid
    @NonNull
    private Microchip microchip;

    @NotBlank(message = "Cat must have a name.")
    private String name;

    private String breed;

    private String type;

    private String primaryColor;

    @Pattern(regexp = "[mfMF]", message = "Cat must be m, f, M or F")
    @NotBlank(message = "Cat must have a sex.")
    private String sex;

    @Max(value = 38, message = "Cat must be between 0 and 38 years old.")
    private int age;

    private boolean declawed;

    private boolean neutered;

    private boolean deceased;

    private boolean purebread;

    private boolean goodWithOtherPets;

    private boolean goodWithKids;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum HairLength {
        NONE,
        SHORT,
        MEDIUM,
        LONG;
    }

    public Cat setMicrochipNumber(Long microchipNumber) {
        return setMicrochip(new Microchip().setMicrochipNumber(microchipNumber));
    }
}
