package com.atmostadam.cats.api.util;

import com.atmostadam.cats.api.exception.CatRuntimeException;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CatApiUtils {
    private CatApiUtils() {}

    private static final ObjectMapper om = new ObjectMapper();

    public static final JsonNode convertToJsonNode(Object o) {
        try {
            return om.readTree(om.writeValueAsString(o));
        } catch (Exception e) {
            throw new CatRuntimeException(e);
        }
    }

    public static boolean catEquals(Object expected, Object actual) {
        return catEquals(convertToJsonNode(expected), convertToJsonNode(actual));
    }

    public static boolean catEquals(JsonNode expected, JsonNode actual) {
        return expected != null && expected.equals(actual);
    }
}
