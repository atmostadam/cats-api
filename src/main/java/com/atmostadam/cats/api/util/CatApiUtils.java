package com.atmostadam.cats.api.util;

import com.atmostadam.cats.api.exception.CatException;
import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.in.CatMicrochipRequest;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;

import java.util.List;

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
