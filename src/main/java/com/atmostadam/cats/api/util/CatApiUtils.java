package com.atmostadam.cats.api.util;

import com.atmostadam.cats.api.entity.CatEntity;
import com.atmostadam.cats.api.exception.CatException;
import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.Microchip;
import com.atmostadam.cats.api.model.in.CatMicrochipRequest;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Simple utility class that can be used for easy conversion between API classes.
 *
 * @author Adam Johnston
 */
public class CatApiUtils {
    private CatApiUtils() {}

    public static final ObjectMapper om = new ObjectMapper();

    public static final String prettyPrint(@NonNull Object o) throws CatException {
        try {
            return om.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (Exception e) {
            throw new CatException(e);
        }
    }

    public static final String defaultPrint(@NonNull Object o) throws CatException {
        try {
            return om.writeValueAsString(o);
        } catch (Exception e) {
            throw new CatException(e);
        }
    }

    public static final CatEntity switchCat(@NonNull Cat cat) {
        return new CatEntity()
                .setMicrochipNumber(cat.getMicrochip().getMicrochipNumber())
                .setName(cat.getName())
                .setBreed(cat.getBreed())
                .setType(cat.getType())
                .setPrimaryColor(cat.getPrimaryColor())
                .setSex(cat.getSex())
                .setAge(cat.getAge())
                .setNeutered(cat.isNeutered())
                .setDeceased(cat.isDeceased());
    }

    public static final Cat switchCat(@NonNull CatEntity catEntity) {
        return new Cat()
                .setMicrochip(new Microchip().setMicrochipNumber(catEntity.getMicrochipNumber()))
                .setName(catEntity.getName())
                .setBreed(catEntity.getBreed())
                .setType(catEntity.getType())
                .setPrimaryColor(catEntity.getPrimaryColor())
                .setSex(catEntity.getSex())
                .setAge(catEntity.getAge())
                .setNeutered(catEntity.getNeutered())
                .setDeceased(catEntity.getDeceased());
    }

    public static final List<Cat> switchCats(@NonNull List<CatEntity> catEntities) {
        List<Cat> cats = new ArrayList<>();
        catEntities.forEach(e -> cats.add(switchCat(e)));
        return cats;
    }

    public static final CatResponse switchException(@NonNull CatRequest request,
                                                    @NonNull Exception exception) {
        return new CatResponse()
                .setMessage(String.format("Microchip numbers [%s] have associated exception message [%s]",
                        concatMicrochips(request.getCats()), exception.getMessage()))
                .setStackTrace(ExceptionUtils.getStackTrace(exception))
                .addCats(request.getCats());
    }

    public static final CatResponse switchException(@NonNull CatMicrochipRequest microchipRequest,
                                                    @NonNull Exception exception) {
        return new CatResponse()
                .setMessage(String.format("Microchip number [%s] have associated exception message [%s]",
                        microchipRequest.getMicrochip().getMicrochipNumber(), exception.getMessage()))
                .setStackTrace(ExceptionUtils.getStackTrace(exception));
    }

    public static final String concatMicrochips(@NonNull List<Cat> cats) {
        StringBuilder microchips = new StringBuilder();
        cats.forEach(e -> microchips.append(e.getMicrochip().getMicrochipNumber()).append(","));
        return StringUtils.removeEnd(microchips.toString(), ",");
    }

    @SneakyThrows
    public static final String logRequestMessage(@NonNull String httpMethod,
                                                 @NonNull String uri,
                                                 @NonNull CatMicrochipRequest microchipRequest) {
        return String.format("HTTP METHOD: [%s],  URI: [%s],  REQUEST [%s]", httpMethod, uri, prettyPrint(microchipRequest));
    }

    @SneakyThrows
    public static final String logRequestMessage(@NonNull String httpMethod,
                                                 @NonNull String uri,
                                                 @NonNull CatRequest request) {
        return String.format("HTTP METHOD: [%s],  URI: [%s],  REQUEST [%s]", httpMethod, uri, prettyPrint(request));
    }

    @SneakyThrows
    public static final String logResponseMessage(@NonNull CatResponse response) {
        return String.format("RESPONSE: [%s]", prettyPrint(response));
    }

    @SneakyThrows
    public static final String logResponseMessage(@NonNull ResponseEntity<CatResponse> response) {
        return String.format("RESPONSE: [%s]", prettyPrint(response));
    }
}
