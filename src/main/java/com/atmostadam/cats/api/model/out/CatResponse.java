package com.atmostadam.cats.api.model.out;

import com.atmostadam.cats.api.model.Cat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Accessors(fluent = false, chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatResponse {
    @NotBlank
    private String message;
    private String stackTrace;
    private final List<Cat> cats = new ArrayList<>();

    public CatResponse addCats(List<Cat> cats) {
        this.cats.addAll(cats);
        return this;
    }

    public CatResponse addCat(Cat cat) {
        this.cats.add(cat);
        return this;
    }

    public ResponseEntity<CatResponse> newResponseEntity(String requestId, HttpStatus status) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put("requestId", List.of(requestId));
        headers.put("Content-Type", List.of(MediaType.APPLICATION_JSON.toString()));
        return newResponseEntity(headers, status);
    }

    public ResponseEntity<CatResponse> newResponseEntity(MultiValueMap<String, String> headers, HttpStatus status) {
        return new ResponseEntity<>(this, headers, status);
    }
}
