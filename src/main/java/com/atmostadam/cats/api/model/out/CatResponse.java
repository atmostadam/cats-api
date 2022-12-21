package com.atmostadam.cats.api.model.out;

import com.atmostadam.cats.api.model.Cat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatResponse {
    @NotBlank
    private String message;

    private String stackTrace;

    private final List<Cat> cats = new ArrayList<>();

    public CatResponse message(String message) {
        this.message = message;
        return this;
    }

    public CatResponse stackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
        return this;
    }
    public CatResponse addCats(List<Cat> cats) {
        this.cats.addAll(cats);
        return this;
    }

    public CatResponse addCat(Cat cat) {
        this.cats.add(cat);
        return this;
    }

    public ResponseEntity<CatResponse> newResponseEntity(HttpStatus status) {
        return new ResponseEntity<>(this, status);
    }
}
