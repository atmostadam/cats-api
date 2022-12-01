package com.atmostadam.cats.api.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class CatApiUtils {
    public static final ObjectMapper om = new ObjectMapper();

    @SneakyThrows
    public static final String prettyPrint(Object o) {
        return om.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }
}
