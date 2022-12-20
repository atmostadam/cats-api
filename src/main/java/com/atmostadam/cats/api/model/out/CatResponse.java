package com.atmostadam.cats.api.model.out;

import com.atmostadam.cats.api.model.Cat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatResponse {
    @NotBlank
    private String transactionId;

    @NotBlank
    private String message;

    private String stackTrace;

    private final List<Cat> cats = new ArrayList<>();
}
