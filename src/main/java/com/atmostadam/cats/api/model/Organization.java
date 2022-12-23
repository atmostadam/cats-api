package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * A JSON object that represents each organization that will be taking care of the cat.
 * <br/>
 * This will include duration. Examples include County Animal Shelter, Humane Society, Cat Charity, Pet Shop, etc.
 */
@Getter
@Setter
@Accessors(fluent = false, chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Organization {
    private OrganizationType organizationType;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum OrganizationType {
        HUMANE_SOCIETY,
        CAT_CHARITY,
        PET_SHOP;
    }
}
