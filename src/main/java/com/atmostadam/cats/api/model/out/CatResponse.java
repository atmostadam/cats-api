package com.atmostadam.cats.api.model.out;

import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatResponse {
    @NotBlank
    private String message;

    private String stackTrace;

    private List<Cat> cats;
}
