package com.atmostadam.cats.api.rest;

import com.atmostadam.cats.api.model.in.CatMicrochipRequest;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/cats/register/1.0/cat", consumes = "application/json", produces = "application/json")
@Api(tags = { "Cats Registration API" })
public interface CatRegistrationResource {
    @GetMapping
    @ApiOperation("This API queries for a cat by microchip number internally within our system.")
    ResponseEntity<CatResponse> queryByMicrochipNumber(@Valid @RequestBody CatMicrochipRequest cat);

    @PostMapping
    @ApiOperation("This API adds a cat or list of cats internally within our system.")
    ResponseEntity<CatResponse> addCat(@Valid @RequestBody CatRequest cat);

    @PatchMapping
    @ApiOperation("This API updates a cat or list of cats internally within our system.")
    ResponseEntity<CatResponse> updateCat(@Valid @RequestBody CatRequest cat);

    @DeleteMapping
    @ApiOperation("This API deletes a cat by microchip number internally within our system.")
    ResponseEntity<CatResponse> deleteCat(@Valid @RequestBody CatMicrochipRequest cat);
}
