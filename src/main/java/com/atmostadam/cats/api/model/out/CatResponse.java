package com.atmostadam.cats.api.model.out;

import com.atmostadam.cats.api.model.in.CatRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatResponse {
    @NotBlank
    private String message;

    private String stackTrace;

    private List<CatRequest> requests;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatResponse that = (CatResponse) o;
        if(requests.size() != that.requests.size()) return false;
        for(CatRequest request : requests) {
            if(!that.requests.contains(request)) {
                return false;
            }
        }
        return message.equals(that.message) && Objects.equals(stackTrace, that.stackTrace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, stackTrace, requests);
    }
}
