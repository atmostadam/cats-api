package com.atmostadam.cats.api.rest;

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
    @GetMapping(value = "/1.0/cat/{microchipNumber}")
    @ApiOperation("This API queries for a cat by microchip number.")
    ResponseEntity<CatResponse> queryByMicrochipNumber(@PathVariable Long microchipNumber);

    @PostMapping(value = "/1.0/cat/{microchipNumber}")
    @ApiOperation("This API adds a cat.")
    ResponseEntity<CatResponse> addCat(@PathVariable Long microchipNumber, @Valid @RequestBody CatRequest cat);

    @PatchMapping(value = "/1.0/cat/{microchipNumber}")
    @ApiOperation("This API updates a cat.")
    ResponseEntity<CatResponse> updateCat(@PathVariable Long microchipNumber, @Valid @RequestBody CatRequest cat);

    @DeleteMapping(value = "/1.0/cat/{microchipNumber}")
    @ApiOperation("This API deletes a cat.")
    ResponseEntity<CatResponse> deleteCat(@PathVariable Long microchipNumber);
}
