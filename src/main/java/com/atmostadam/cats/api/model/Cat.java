package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

/** A JSON object that represents the actual cat itself. */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    private boolean neutered;

    private boolean deceased;
}
