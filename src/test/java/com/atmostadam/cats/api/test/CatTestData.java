package com.atmostadam.cats.api.test;

import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.Microchip;
import com.atmostadam.cats.api.model.in.CatRequest;

import java.util.UUID;

public final class CatTestData {
    private CatTestData() { }

    public static String TEST_REQUEST_ID = "d1e2a63e-7c43-47ba-8721-ab872640b0b1";
    public static Long TEST_MICROCHIP_NUMBER = 431654132132657L;

    public static Cat cat() {
        Cat cat = new Cat();
        Microchip microchip = new Microchip();
        microchip.setMicrochipNumber(431654132132657L);
        cat.setMicrochip(microchip);
        cat.setName("Shelley");
        cat.setBreed("Domestic Shorthair");
        cat.setType("Calico");
        cat.setPrimaryColor("Orange");
        cat.setSex("F");
        cat.setAge(2);
        cat.setDeceased(false);
        cat.setNeutered(true);
        return cat;
    }

    public static CatRequest request() {
        return new CatRequest().addCat(cat());
    }
}
