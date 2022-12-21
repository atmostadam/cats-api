package com.atmostadam.cats.api.model.in;

import com.atmostadam.cats.api.model.Microchip;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatMicrochipRequest {
    @Valid
    @NotNull
    private Microchip microchip;

    public CatMicrochipRequest message(Microchip microchip) {
        this.microchip = microchip;
        return this;
    }

    public CatMicrochipRequest microchipNumber(Long microchipNumber) {
        this.microchip = new Microchip().microchipNumber(microchipNumber);
        return this;
    }
}
