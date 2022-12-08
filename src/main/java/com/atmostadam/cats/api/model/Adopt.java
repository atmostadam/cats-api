package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * A JSON object that represents the person or organization where the cat has been adopted out.
 * <br/>
 * Examples include Cat Sanctuary, Person, Family, No-Kill Shelter, etc.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Adopt {
    private Person adoptTo;

    private Cat adopted;

    private Organization adoptFrom;
}
