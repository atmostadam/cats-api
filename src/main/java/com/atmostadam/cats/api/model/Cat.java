package com.atmostadam.cats.api.model;

import com.atmostadam.cats.api.entity.CatEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.time.Instant;

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
    /** Worldwide 9 to 15 digit number unique identifier for a chip that goes into the back of a pet's neck. */
    @Min(value = 100000000L, message = "Microchip Number must 9 digits or greater based on manufacturer standards.")
    @Max(value = 999999999999999L, message = "Microchip Number must 15 digits or less based on manufacturer standards.")
    private Long microchipNumber;

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

    public CatEntity newCatEntity() {
        return new CatEntity()
                .setMicrochipNumber(microchipNumber)
                .setName(name)
                .setBreed(breed)
                .setType(type)
                .setPrimaryColor(primaryColor)
                .setSex(sex)
                .setAge(age)
                .setNeutered(neutered)
                .setDeceased(deceased)
                .setCreatedTimestamp(Timestamp.from(Instant.now()))
                .setUpdatedTimestamp(Timestamp.from(Instant.now()));
    }
}
