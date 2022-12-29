package com.atmostadam.cats.api.service;

import com.atmostadam.cats.api.model.in.CatMicrochipRequest;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CatRegistrationService {
    ResponseEntity<CatResponse> queryByMicrochipNumber(String requestId, CatMicrochipRequest microchipRequest);

    ResponseEntity<CatResponse> insertSingleRow(String requestId, CatRequest request);

    ResponseEntity<CatResponse> updateSingleRow(String requestId, CatRequest request);

    ResponseEntity<CatResponse> deleteSingleRow(String requestId, CatMicrochipRequest microchipRequest);
}
