package com.atmostadam.cats.api.rest;

import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/cats/process/1.0/cat", consumes = "application/json", produces = "application/json")
public interface CatProcessResource {
    @PostMapping(value = "/medical")
    @ApiOperation("This API treats a cat or list of cats for one or more diseases.")
    ResponseEntity<CatResponse> treatCat(@Valid @RequestBody CatRequest cat);

    @PostMapping(value = "/microchip")
    @ApiOperation("This API microchips a cat or list of cats.")
    ResponseEntity<CatResponse> microchipCat(@Valid @RequestBody CatRequest cat);

    @PostMapping(value = "/petfinder")
    @ApiOperation("This API posts a cat or list of cats to Petfinder.")
    ResponseEntity<CatResponse> postPetfinderCat(@Valid @RequestBody CatRequest cat);

    @PostMapping(value = "/adoptapet")
    @ApiOperation("This API posts a cat or list of cats to Adopt-A-Pet.")
    ResponseEntity<CatResponse> postAdoptAPetCat(@Valid @RequestBody CatRequest cat);
}