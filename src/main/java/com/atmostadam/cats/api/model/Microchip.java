package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Microchip {
    /** Worldwide 9 to 15 digit number unique identifier for a chip that goes into the back of a pet's neck. */
    @Min(value = 100000000L, message = "Microchip Number must 9 digits or greater based on manufacturer standards.")
    @Max(value = 999999999999999L, message = "Microchip Number must 15 digits or less based on manufacturer standards.")
    private Long microchipNumber;
}
