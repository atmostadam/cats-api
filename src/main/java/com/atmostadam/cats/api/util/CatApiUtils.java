package com.atmostadam.cats.api.util;

import com.atmostadam.cats.api.entity.CatEntity;
import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.Microchip;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

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
}
