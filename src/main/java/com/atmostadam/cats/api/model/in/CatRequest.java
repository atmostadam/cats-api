package com.atmostadam.cats.api.model.in;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatRequest {

    /** Worldwide 9 to 15 digit number unique identifier for a chip that goes into the back of a pet's neck. */
    @Min(9)
    @Max(15)
    private Long microchipNumber;

    @NotBlank
    private String name;

    private String breed;

    private String type;

    private String primaryColor;

    @Pattern(regexp = "[m,f,M,F]")
    private String sex;

    @Max(2)
    private int age;

    private boolean deceased;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatRequest that = (CatRequest) o;
        return age == that.age && deceased == that.deceased && microchipNumber.equals(that.microchipNumber) && Objects.equals(name, that.name) && Objects.equals(breed, that.breed) && Objects.equals(type, that.type) && Objects.equals(primaryColor, that.primaryColor) && Objects.equals(sex, that.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(microchipNumber, name, breed, type, primaryColor, sex, age, deceased);
    }
}
