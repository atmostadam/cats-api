package com.atmostadam.cats.api.model.in;

import com.atmostadam.cats.api.model.Microchip;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatMicrochipRequest {
    @NotBlank
    private String transactionId;

    @Valid
    private Microchip microchip;
}
