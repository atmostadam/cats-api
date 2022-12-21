package com.atmostadam.cats.api.model.out;

import com.atmostadam.cats.api.model.Cat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public CatResponse stackTrace(Exception e) {
        return stackTrace(ExceptionUtils.getStackTrace(e));
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

    public ResponseEntity<CatResponse> newResponseEntity(MultiValueMap<String, String> headers, HttpStatus status) {
        return new ResponseEntity<>(this, headers, status);
    }
}
