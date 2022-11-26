package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * A JSON object that represents the location where the cat will be taken to for treatment and processing
 * before being transferred to a location.
 * <br/>
 * This facility must perform all government required treatments including mirco chip, spayed or neutered,
 * flea treatments as well as any treatments depending upon the condition of the cat.
 * Examples of such facilities include Animal Shelter, Humane Society, Animal Hospital, Cat Charity, Pet Shop, etc.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Intake {
    private Location location;

}
