package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * A JSON object that represents a disease that a cat might have.
 * <br/>
 * Government required operations including mirco chip, spayed or neutered, flea treatments must also be performed.
 * Examples of diseases include Leukemia, Fleas, Ticks, Upper Repository Disease, Heart Disuse, etc.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
//@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Disease {

}
