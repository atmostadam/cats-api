package com.atmostadam.cats.api.rest;

import com.atmostadam.cats.api.model.in.CatMicrochipRequest;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.atmostadam.cats.api.service.CatRegistrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/cats/register/1.0/cat", consumes = "application/json", produces = "application/json")
@Api(tags = { "Cats Registration API" })
public class CatRegistrationResource {
    @Autowired
    private CatRegistrationService service;

    @GetMapping
    @ApiOperation("This API queries for a cat by microchip number internally within our system.")
    ResponseEntity<CatResponse> queryByMicrochipNumber(@RequestHeader(value = "requestId") String requestId,
                                                       @Valid @RequestBody CatMicrochipRequest microchipRequest) {
        return service.queryByMicrochipNumber(requestId, microchipRequest);
    }

    @PostMapping
    @ApiOperation("This API adds a cat or list of cats internally within our system.")
    ResponseEntity<CatResponse> addCat(@RequestHeader(value = "requestId") String requestId,
                                       @Valid @RequestBody CatRequest request) {
        return service.insertSingleRow(requestId, request);
    }

    @PatchMapping
    @ApiOperation("This API updates a cat or list of cats internally within our system.")
    ResponseEntity<CatResponse> updateCat(@RequestHeader(value = "requestId") String requestId,
                                          @Valid @RequestBody CatRequest request) {
        return service.updateSingleRow(requestId, request);
    }

    @DeleteMapping
    @ApiOperation("This API deletes a cat by microchip number internally within our system.")
    ResponseEntity<CatResponse> deleteCat(@RequestHeader(value = "requestId") String requestId,
                                          @Valid @RequestBody CatMicrochipRequest microchipRequest) {
        return service.deleteSingleRow(requestId, microchipRequest);
    }
}
