package com.atmostadam.cats.api.util;

import com.atmostadam.cats.api.entity.CatEntity;
import com.atmostadam.cats.api.exception.CatException;
import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.Microchip;
import com.atmostadam.cats.api.model.in.CatMicrochipRequest;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CatApiUtils {
    private CatApiUtils() {}

    public static final ObjectMapper om = new ObjectMapper();

    @SneakyThrows
    public static final String sneakyPrettyPrint(Object o) {
        return om.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }

    @SneakyThrows
    public static final String sneakyDefaultPrint(Object o) {
        return om.writeValueAsString(o);
    }

    public static final CatEntity switchCat(Cat cat) {
        return CatEntity.builder()
                .microchipNumber(cat.getMicrochip().getMicrochipNumber())
                .name(cat.getName())
                .breed(cat.getBreed())
                .type(cat.getType())
                .primaryColor(cat.getPrimaryColor())
                .sex(cat.getSex())
                .age(cat.getAge())
                .neutered(cat.isNeutered())
                .deceased(cat.isDeceased())
                .build();
    }

    public static final Cat switchCat(CatEntity catEntity) {
        return Cat.builder()
                .microchip(Microchip.builder().microchipNumber(catEntity.getMicrochipNumber()).build())
                .name(catEntity.getName())
                .breed(catEntity.getBreed())
                .type(catEntity.getType())
                .primaryColor(catEntity.getPrimaryColor())
                .sex(catEntity.getSex())
                .age(catEntity.getAge())
                .neutered(catEntity.getNeutered())
                .deceased(catEntity.getDeceased())
                .build();
    }

    public static final List<Cat> switchCats(@NonNull List<CatEntity> catEntities) {
        List<Cat> cats = new ArrayList<>();
        catEntities.forEach(e -> cats.add(switchCat(e)));
        return cats;
    }

    public static final CatResponse switchException(CatRequest request, Exception exception) {
        CatResponse response = new CatResponse();
        response.setTransactionId(request.getTransactionId());
        response.setCats(request.getCats());
        StringBuilder microchips = new StringBuilder();
        request.getCats().forEach(e -> microchips.append(microchips).append(","));
        response.setMessage(String.format("Transaction ID [%s] microchip numbers [%s] exception message [%s]",
                request.getTransactionId(), StringUtils.removeEnd(microchips.toString(), ","),
                exception.getMessage()));
        response.setStackTrace(ExceptionUtils.getStackTrace(exception));
        return response;
    }

    public static final CatResponse switchException(CatMicrochipRequest microchipRequest, Exception exception) {
        CatResponse response = new CatResponse();
        response.setTransactionId(microchipRequest.getTransactionId());
        response.setMessage(exception.getMessage());
        response.setMessage(String.format("Transaction ID [%s] microchip number [%s] exception message [%s]",
                microchipRequest.getTransactionId(), microchipRequest.getMicrochip().getMicrochipNumber(),
                exception.getMessage()));
        response.setStackTrace(ExceptionUtils.getStackTrace(exception));
        return response;
    }

    public static final ResponseEntity<CatResponse> successResponse(String transactionId,
                                                                    String message,
                                                                    List<Cat> cats) {
        return new ResponseEntity<>(CatResponse.builder()
                .transactionId(transactionId)
                .message(message)
                .cats(cats)
                .build(),
                HttpStatus.OK);
    }

    public static final ResponseEntity<CatResponse> http500Response(String transactionId,
                                                                    Exception exception,
                                                                    List<Cat> cats) {
        return new ResponseEntity<>(CatResponse.builder()
                .transactionId(transactionId)
                .message(exception.getMessage())
                .stackTrace(ExceptionUtils.getStackTrace(exception))
                .cats(cats)
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static final String concatMicrochips(List<Cat> cats) {
        List<Long> microchips = new ArrayList<>();
        Objects.requireNonNull(cats).forEach(e -> microchips.add(e.getMicrochip().getMicrochipNumber()));
        StringBuilder sb = new StringBuilder();
        microchips.forEach(e -> sb.append(e).append(","));
        return StringUtils.removeEnd(sb.toString(), ",");
    }
}