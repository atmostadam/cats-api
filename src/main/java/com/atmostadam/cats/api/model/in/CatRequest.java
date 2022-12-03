package com.atmostadam.cats.api.model.in;

import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.Intake;
import com.atmostadam.cats.api.model.Delivery;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatRequest {
    @NotBlank
    private String transactionId;

    @Valid
    private List<Cat> cats = new ArrayList<>();

    @Valid
    private Intake intake;

    @Valid
    private Delivery delivery;
}
