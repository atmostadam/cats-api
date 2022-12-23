package com.atmostadam.cats.api.model.in;

import com.atmostadam.cats.api.model.Microchip;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Accessors(fluent = false, chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatMicrochipRequest {
    @Valid
    @NotNull
    private Microchip microchip;

    public CatMicrochipRequest setMicrochipNumber(Long microchipNumber) {
        this.microchip = new Microchip().microchipNumber(microchipNumber);
        return this;
    }

    public CatResponse newCatResponse(@NonNull Exception exception) {
        return new CatResponse()
                .setMessage(String.format("Microchip number [%s] have associated exception message [%s]",
                        microchip.getMicrochipNumber(), exception.getMessage()))
                .setStackTrace(ExceptionUtils.getStackTrace(exception));
    }
}
