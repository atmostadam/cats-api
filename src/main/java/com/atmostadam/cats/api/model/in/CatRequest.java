package com.atmostadam.cats.api.model.in;

import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.Delivery;
import com.atmostadam.cats.api.model.Intake;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static com.atmostadam.cats.api.util.CatApiUtils.concatMicrochips;

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

    public CatResponse newCatResponse(@NonNull Exception exception) {
        return new CatResponse()
                .setMessage(String.format("Microchip numbers [%s] have associated exception message [%s]",
                        concatMicrochips(cats), exception.getMessage()))
                .setStackTrace(ExceptionUtils.getStackTrace(exception))
                .addCats(cats);
    }
}
