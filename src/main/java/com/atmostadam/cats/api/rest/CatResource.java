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
@RequestMapping(value = "cats", consumes = "application/json", produces = "application/json")
@Api(tags = { "Cats API" })
public interface CatResource {
    @GetMapping(value = "/1.0/cat")
    @ApiOperation("This API queries for a cat by microchip number internally within our system.")
    ResponseEntity<CatResponse> queryByMicrochipNumber(@Valid @RequestBody CatMicrochipRequest cat);

    @PostMapping(value = "/1.0/cat")
    @ApiOperation("This API adds a cat or list of cats internally within our system.")
    ResponseEntity<CatResponse> addCat(@Valid @RequestBody CatRequest cat);

    @PatchMapping(value = "/1.0/cat")
    @ApiOperation("This API updates a cat or list of cats internally within our system.")
    ResponseEntity<CatResponse> updateCat(@Valid @RequestBody CatRequest cat);

    @DeleteMapping(value = "/1.0/cat")
    @ApiOperation("This API deletes a cat by microchip number internally within our system.")
    ResponseEntity<CatResponse> deleteCat(@Valid @RequestBody CatMicrochipRequest cat);

    @PostMapping(value = "/1.0/cat/onboard")
    @ApiOperation("This API onboards a new cat or list of cats into the foster system of our charity.")
    ResponseEntity<CatResponse> onboardCat(@Valid @RequestBody CatRequest cat);

    ResponseEntity<CatResponse> fosterCat(@Valid @RequestBody CatRequest cat);

    ResponseEntity<CatResponse> adoptCat(@Valid @RequestBody CatRequest cat);

    ResponseEntity<CatResponse> transferCat(@Valid @RequestBody CatRequest cat);

    ResponseEntity<CatResponse> shipCat(@Valid @RequestBody CatRequest cat);

    ResponseEntity<CatResponse> treatCat(@Valid @RequestBody CatRequest cat);

    ResponseEntity<CatResponse> microchipCat(@Valid @RequestBody CatRequest cat);

    ResponseEntity<CatResponse> postPetfinderCat(@Valid @RequestBody CatRequest cat);

    ResponseEntity<CatResponse> postAdoptAPetCat(@Valid @RequestBody CatRequest cat);

    ResponseEntity<CatResponse> registerCat(@Valid @RequestBody CatRequest cat);
}
