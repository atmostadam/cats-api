package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cat {
    /** Worldwide 9 to 15 digit number unique identifier for a chip that goes into the back of a pet's neck. */
    @Min(9)
    @Max(15)
    private Long microchipNumber;

    @NotBlank
    private String name;

    private String breed;

    private String type;

    private String primaryColor;

    @Pattern(regexp = "[m,f,M,F]")
    private String sex;

    @Max(2)
    private int age;

    private boolean deceased;
}
