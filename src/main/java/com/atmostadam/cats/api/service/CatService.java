package com.atmostadam.cats.api.service;

import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import org.springframework.http.ResponseEntity;

public interface CatService {
    ResponseEntity<CatResponse> invoke(String requestId, CatRequest request);
}
