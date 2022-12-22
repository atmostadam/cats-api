package com.atmostadam.cats.api.model.in;

import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.Delivery;
import com.atmostadam.cats.api.model.Intake;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Accessors(fluent = false, chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatRequest {
    @Valid
    private final List<Cat> cats = new ArrayList<>();
    @Valid
    private Intake intake;
    @Valid
    private Delivery delivery;

    public CatRequest addCats(List<Cat> cats) {
        this.cats.addAll(cats);
        return this;
    }

    public CatRequest addCat(Cat cat) {
        this.cats.add(cat);
        return this;
    }
}
