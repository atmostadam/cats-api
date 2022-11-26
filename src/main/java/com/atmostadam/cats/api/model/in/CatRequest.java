package com.atmostadam.cats.api.model.in;

import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.Intake;
import com.atmostadam.cats.api.model.Delivery;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatRequest {
    @NotBlank
    private String id;

    @Valid
    @NonNull
    private List<Cat> cats;

    @Valid
    private Intake intake;

    @Valid
    private Delivery delivery;
}
