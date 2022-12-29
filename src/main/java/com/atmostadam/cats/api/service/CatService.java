package com.atmostadam.cats.api.service;

import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import org.springframework.http.ResponseEntity;

public interface CatService {
    ResponseEntity<CatResponse> onboardCat(String requestId, CatRequest request);

    ResponseEntity<CatResponse> transferCat(String requestId, CatRequest request);

    ResponseEntity<CatResponse> fosterCat(String requestId,  CatRequest request);

    ResponseEntity<CatResponse> adoptCat(String requestId, CatRequest request);
}
