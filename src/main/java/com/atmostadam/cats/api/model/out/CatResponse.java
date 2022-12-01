package com.atmostadam.cats.api.model.out;

import com.atmostadam.cats.api.model.Cat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatResponse {
    @NotBlank
    private String message;

    private String stackTrace;

    private List<Cat> cats = new ArrayList<>();
}
