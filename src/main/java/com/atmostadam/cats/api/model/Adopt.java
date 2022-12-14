package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * A JSON object that represents the person or organization where the cat has been adopted out.
 * <br/>
 * Examples include Cat Sanctuary, Person, Family, No-Kill Shelter, etc.
 */
@Getter
@Setter
@Accessors(fluent = false, chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Adopt {
    private String id;
    private String firstName;
    private String lastName;
    private String businessName;
}
