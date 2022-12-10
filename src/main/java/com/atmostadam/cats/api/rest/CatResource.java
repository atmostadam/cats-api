package com.atmostadam.cats.api.rest;

import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/cats/1.0/cat", consumes = "application/json", produces = "application/json")
@Api(tags = { "Cats API", "Cat Charity Organization", "Demo", "Showcase", "Prototype" })
public interface CatResource {
    @PostMapping(value = "/onboard")
    @ApiOperation("This API onboards a new cat or list of cats into the foster system of our charity.")
    ResponseEntity<CatResponse> onboardCat(@Valid @RequestBody CatRequest cat);

    @PostMapping(value = "/transfer")
    @ApiOperation("This API transfers a cat or list of cats from one location to another.")
    ResponseEntity<CatResponse> transferCat(@Valid @RequestBody CatRequest cat);

    @PostMapping(value = "/transfer/foster")
    @ApiOperation("This API transfers a cat or list of cats to a foster home.")
    ResponseEntity<CatResponse> fosterCat(@Valid @RequestBody CatRequest cat);

    @PostMapping(value = "/adopt")
    @ApiOperation("This API adopts a cat or list of cats to a new guardian.")
    ResponseEntity<CatResponse> adoptCat(@Valid @RequestBody CatRequest cat);


}
