package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {
    private PersonType personType;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum PersonType {
        OWNER,
        ADOPTER,
        FOSTER,
        VISITOR,
        VETERINARIAN,
        VET_TECH,
        VOLUNTEER,
        DELIVERER
    }
}
