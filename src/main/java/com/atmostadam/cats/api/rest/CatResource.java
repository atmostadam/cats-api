package com.atmostadam.cats.api.rest;

import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.atmostadam.cats.api.service.CatService;
import com.atmostadam.cats.api.service.CatSpringBeanServiceNames;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(value = "/cats/1.0/cat", consumes = "application/json", produces = "application/json")
public class CatResource {
    public static final Logger logger = LoggerFactory.getLogger(CatResource.class);
    public static final ObjectMapper om = new ObjectMapper();
    @Autowired
    @Qualifier(CatSpringBeanServiceNames.SERVICE_MAP)
    private Map<String, CatService> serviceMap;

    @GetMapping
    // This API queries for a cat by microchip number internally within our system.
    public ResponseEntity<CatResponse> queryByMicrochipNumber(@RequestHeader(value = "requestId") String requestId,
                                                       @Valid @RequestBody CatRequest request) {
        return invokeService(CatSpringBeanServiceNames.QUERY_BY_MICROSERVICE_NUMBER, requestId, request);
    }

    @PostMapping
    // This API adds a cat or list of cats internally within our system.
    public ResponseEntity<CatResponse> addCat(@RequestHeader(value = "requestId") String requestId,
                                       @Valid @RequestBody CatRequest request) {
        return invokeService(CatSpringBeanServiceNames.ADD_CAT, requestId, request);
    }

    @PatchMapping
    // This API updates a cat or list of cats internally within our system.
    public ResponseEntity<CatResponse> updateCat(@RequestHeader(value = "requestId") String requestId,
                                          @Valid @RequestBody CatRequest request) {
        return invokeService(CatSpringBeanServiceNames.UPDATE_CAT, requestId, request);
    }

    @DeleteMapping
    // This API deletes a cat by microchip number internally within our system.
    public ResponseEntity<CatResponse> deleteCat(@RequestHeader(value = "requestId") String requestId,
                                          @Valid @RequestBody CatRequest request) {
        return invokeService(CatSpringBeanServiceNames.DELETE_CAT, requestId, request);
    }

    @PostMapping(value = "/register/onboard")
    // This API onboards a new cat or list of cats into the foster system of our charity.
    public ResponseEntity<CatResponse> onboardCat(@RequestHeader(value = "requestId") String requestId,
                                           @Valid @RequestBody CatRequest request) {
        return invokeService(CatSpringBeanServiceNames.ONBOARD_CAT, requestId, request);
    }

    @PostMapping(value = "/register/transfer")
    // This API transfers a cat or list of cats from one location to another.
    public ResponseEntity<CatResponse> transferCat(@RequestHeader(value = "requestId") String requestId,
                                            @Valid @RequestBody CatRequest request) {
        return invokeService(CatSpringBeanServiceNames.TRANSFER_CAT, requestId, request);
    }

    @PostMapping(value = "/register/transfer/foster")
    // This API transfers a cat or list of cats to a foster home.
    public ResponseEntity<CatResponse> fosterCat(@RequestHeader(value = "requestId") String requestId,
                                          @Valid @RequestBody CatRequest request){
        return invokeService(CatSpringBeanServiceNames.FOSTER_CAT, requestId, request);
    }

    @PostMapping(value = "/register/adopt")
    // This API adopts a cat or list of cats to a new guardian.
    public ResponseEntity<CatResponse> adoptCat(@RequestHeader(value = "requestId") String requestId,
                                         @Valid @RequestBody CatRequest request) {
        return invokeService(CatSpringBeanServiceNames.ADOPT_CAT, requestId, request);
    }

    @PostMapping(value = "/process/medical")
    // This API treats a cat or list of cats for one or more diseases.
    public ResponseEntity<CatResponse> treatCat(@RequestHeader(value = "requestId") String requestId,
                                         @Valid @RequestBody CatRequest request) {
        return invokeService(CatSpringBeanServiceNames.TREAT_CAT, requestId, request);
    }

    @PostMapping(value = "/process/microchip")
    // This API microchips a cat or list of cats.
    public ResponseEntity<CatResponse> microchipCat(@RequestHeader(value = "requestId") String requestId,
                                             @Valid @RequestBody CatRequest request) {
        return invokeService(CatSpringBeanServiceNames.MICROCHIP_CAT, requestId, request);
    }

    @PostMapping(value = "/process/petfinder")
    // This API posts a cat or list of cats to Petfinder.
    public ResponseEntity<CatResponse> postPetfinderCat(@RequestHeader(value = "requestId") String requestId,
                                                 @Valid @RequestBody CatRequest request) {
        return invokeService(CatSpringBeanServiceNames.POST_PETFINDER_CAT, requestId, request);
    }

    @PostMapping(value = "/process/adoptapet")
    // This API posts a cat or list of cats to Adopt-A-Pet.
    public ResponseEntity<CatResponse> postAdoptAPetCat(@RequestHeader(value = "requestId") String requestId,
                                                 @Valid @RequestBody CatRequest request) {
        return invokeService(CatSpringBeanServiceNames.POST_ADOPT_A_PET_CAT, requestId, request);
    }

    private ResponseEntity<CatResponse> invokeService(String name, String requestId, CatRequest request) {
        ResponseEntity<CatResponse> response;
        try {
            if (!serviceMap.containsKey(name)) {
                throw new NoSuchBeanDefinitionException(name, String.format(
                        "Service Spring Bean implementing [%s] must be injected with name [%s]. Valid names are %s.",
                        CatService.class.getSimpleName(), name, CatSpringBeanServiceNames.SERVICE_NAMES));
            }

            if (logger.isDebugEnabled()) {
                logger.debug(String.format("SERVICE NAME: [%s],  REQUEST ID: [%s],  REQUEST [%s]",
                        name, requestId, om.writerWithDefaultPrettyPrinter().writeValueAsString(request)));
            }

            response = serviceMap.get(name).invoke(requestId, request);

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
