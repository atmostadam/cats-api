package com.atmostadam.cats.api.service;

import com.atmostadam.cats.api.model.CatResponseTest;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public abstract class CatServiceTest implements CatService {
    public static final Logger logger = LoggerFactory.getLogger(CatServiceTest.class);

    @Override
    public ResponseEntity<CatResponse> invoke(String requestId, CatRequest request) {
        logger.info(String.format(
                "[SERVICE INVOKE] - [%s] [%s] [%s]", this.getClass().getSimpleName(),
                requestId, request));
        return CatResponseTest.testData().newResponseEntity(requestId, HttpStatus.OK);
    }
}
