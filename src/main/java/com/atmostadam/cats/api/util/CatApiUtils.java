package com.atmostadam.cats.api.util;

import com.atmostadam.cats.api.model.Cat;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Simple utility class that can be used for easy conversion between API classes.
 *
 * @author Adam Johnston
 */
public class CatApiUtils {
    private CatApiUtils() {}


    public static final String concatMicrochips(@NonNull List<Cat> cats) {
        StringBuilder microchips = new StringBuilder();
        cats.forEach(e -> microchips.append(e.getMicrochipNumber()).append(","));
        return StringUtils.removeEnd(microchips.toString(), ",");
    }
}
