package com.atmostadam.cats.api.rest;

import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.atmostadam.cats.api.service.CatService;
import com.atmostadam.cats.api.service.CatServiceNames;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(value = "/cats/1.0/cat", consumes = "application/json", produces = "application/json")
@Api(tags = { "Cats API", "Cat Charity Organization", "Demo", "Showcase", "Prototype" })
public class CatResource {
    public static final Logger logger = LoggerFactory.getLogger(CatResource.class);
    public static final ObjectMapper om = new ObjectMapper();
    @Autowired
    private Map<String, CatService> service;

    @GetMapping
    @ApiOperation("This API queries for a cat by microchip number internally within our system.")
    ResponseEntity<CatResponse> queryByMicrochipNumber(@RequestHeader(value = "requestId") String requestId,
                                                       @Valid @RequestBody CatRequest request) {
        return invokeService(CatServiceNames.QUERY_BY_MICROSERVICE_NUMBER, requestId, request);
    }

    @PostMapping
    @ApiOperation("This API adds a cat or list of cats internally within our system.")
    ResponseEntity<CatResponse> addCat(@RequestHeader(value = "requestId") String requestId,
                                       @Valid @RequestBody CatRequest request) {
        return invokeService(CatServiceNames.ADD_CAT, requestId, request);
    }

    @PatchMapping
    @ApiOperation("This API updates a cat or list of cats internally within our system.")
    ResponseEntity<CatResponse> updateCat(@RequestHeader(value = "requestId") String requestId,
                                          @Valid @RequestBody CatRequest request) {
        return invokeService(CatServiceNames.UPDATE_CAT, requestId, request);
    }

    @DeleteMapping
    @ApiOperation("This API deletes a cat by microchip number internally within our system.")
    ResponseEntity<CatResponse> deleteCat(@RequestHeader(value = "requestId") String requestId,
                                          @Valid @RequestBody CatRequest request) {
        return invokeService(CatServiceNames.DELETE_CAT, requestId, request);
    }

    @PostMapping(value = "/register/onboard")
    @ApiOperation("This API onboards a new cat or list of cats into the foster system of our charity.")
    ResponseEntity<CatResponse> onboardCat(@RequestHeader(value = "requestId") String requestId,
                                           @Valid @RequestBody CatRequest request) {
        return invokeService(CatServiceNames.ONBOARD_CAT, requestId, request);
    }

    @PostMapping(value = "/register/transfer")
    @ApiOperation("This API transfers a cat or list of cats from one location to another.")
    ResponseEntity<CatResponse> transferCat(@RequestHeader(value = "requestId") String requestId,
                                            @Valid @RequestBody CatRequest request) {
        return invokeService(CatServiceNames.TRANSFER_CAT, requestId, request);
    }

    @PostMapping(value = "/register/transfer/foster")
    @ApiOperation("This API transfers a cat or list of cats to a foster home.")
    ResponseEntity<CatResponse> fosterCat(@RequestHeader(value = "requestId") String requestId,
                                          @Valid @RequestBody CatRequest request){
        return invokeService(CatServiceNames.FOSTER_CAT, requestId, request);
    }

    @PostMapping(value = "/register/adopt")
    @ApiOperation("This API adopts a cat or list of cats to a new guardian.")
    ResponseEntity<CatResponse> adoptCat(@RequestHeader(value = "requestId") String requestId,
                                         @Valid @RequestBody CatRequest request) {
        return invokeService(CatServiceNames.ADOPT_CAT, requestId, request);
    }

    @PostMapping(value = "/process/medical")
    @ApiOperation("This API treats a cat or list of cats for one or more diseases.")
    ResponseEntity<CatResponse> treatCat(@RequestHeader(value = "requestId") String requestId,
                                         @Valid @RequestBody CatRequest request) {
        return invokeService(CatServiceNames.TREAT_CAT, requestId, request);
    }

    @PostMapping(value = "/process/microchip")
    @ApiOperation("This API microchips a cat or list of cats.")
    ResponseEntity<CatResponse> microchipCat(@RequestHeader(value = "requestId") String requestId,
                                             @Valid @RequestBody CatRequest request) {
        return invokeService(CatServiceNames.MICROCHIP_CAT, requestId, request);
    }

    @PostMapping(value = "/process/petfinder")
    @ApiOperation("This API posts a cat or list of cats to Petfinder.")
    ResponseEntity<CatResponse> postPetfinderCat(@RequestHeader(value = "requestId") String requestId,
                                                 @Valid @RequestBody CatRequest request) {
        return invokeService(CatServiceNames.POST_PETFINDER_CAT, requestId, request);
    }

    @PostMapping(value = "/process/adoptapet")
    @ApiOperation("This API posts a cat or list of cats to Adopt-A-Pet.")
    ResponseEntity<CatResponse> postAdoptAPetCat(@RequestHeader(value = "requestId") String requestId,
                                                 @Valid @RequestBody CatRequest request) {
        return invokeService(CatServiceNames.POST_ADOPT_A_PET_CAT, requestId, request);
    }

    private ResponseEntity<CatResponse> invokeService(String name, String requestId, CatRequest request) {
        ResponseEntity<CatResponse> response;
        try {
            if (!service.containsKey(name)) {
                throw new NoSuchBeanDefinitionException(name, String.format(
                        "Transaction with request id [%s] invoked unsupported service [%s] with request [%s]",
                        requestId, name, om.writerWithDefaultPrettyPrinter().writeValueAsString(request)));
            }

            if (logger.isDebugEnabled()) {
                logger.debug(String.format("SERVICE NAME: [%s],  REQUEST ID: [%s],  REQUEST [%s]",
                        name, requestId, om.writerWithDefaultPrettyPrinter().writeValueAsString(request)));
            }

            response = service.get(name).invoke(requestId, request);

            if (logger.isDebugEnabled()) {
                logger.debug(String.format("SERVICE NAME: [%s],  REQUEST ID: [%s],  RESPONSE: [%s]",
                        name, requestId, om.writerWithDefaultPrettyPrinter().writeValueAsString(response.getBody())));
            }
        } catch (JsonProcessingException jpe) {
            response = new CatResponse().
                    setException(jpe)
                    .addCats(request.getCats())
                    .newResponseEntity(requestId, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
