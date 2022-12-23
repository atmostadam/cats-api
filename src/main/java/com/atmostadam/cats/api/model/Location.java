package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * A JSON object that represents the location where the cat will be spayed or neutered and treated for
 * diseases.
 * <br/>
 * Examples include Animal Shelter, Animal Control, Veterinary Hospital, Humane Society, etc.
 */
@Getter
@Setter
@Accessors(fluent = false, chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

    public enum LocationType {
        GOVERNMENT_FACILITY,
        VETERINARY_HOSPITAL,
        HUMANE_SOCIETY;
    }
}
