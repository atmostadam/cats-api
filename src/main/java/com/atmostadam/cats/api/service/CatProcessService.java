package com.atmostadam.cats.api.service;

import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CatProcessService {
    ResponseEntity<CatResponse> treatCat(String requestId, CatRequest cat);

    ResponseEntity<CatResponse> microchipCat(String requestId, CatRequest cat);

    ResponseEntity<CatResponse> postPetfinderCat(String requestId, CatRequest cat);

    ResponseEntity<CatResponse> postAdoptAPetCat(String requestId, CatRequest cat);
}
