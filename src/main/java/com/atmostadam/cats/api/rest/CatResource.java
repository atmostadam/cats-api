package com.atmostadam.cats.api.rest;

import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "cats", consumes = "application/json", produces = "application/json")
public interface CatResource {
    @GetMapping(value = "/1.0/cat/{microchipNumber}")
    public ResponseEntity<CatResponse> queryByMicrochipNumber(@PathVariable String microchipNumber);

    @PostMapping(value = "/1.0/cat/{microchipNumber}")
    public ResponseEntity<CatResponse> addCat(@PathVariable String microchipNumber, @RequestBody CatRequest cat);

    @PatchMapping(value = "/1.0/cat/{microchipNumber}")
    public ResponseEntity<CatResponse> updateCat(@PathVariable String microchipNumber, @RequestBody CatRequest cat);

    @DeleteMapping(value = "/1.0/cat/{microchipNumber}")
    public ResponseEntity<CatResponse> deleteCat(@PathVariable String microchipNumber);
}
