package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * A JSON object that represents the delivery method of the person dropping off the cat(s).
 * <br/>
 * This will include owner turn in, stray turn in, trapped, etc., Animal Shelter, Humane Society, Animal Hospital, Cat Charity, Pet Shop, etc.
 */
@Getter
@Setter
@Accessors(fluent = false, chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Delivery {
    private List<Cat> cats;

    private Location deliverTo;
}
