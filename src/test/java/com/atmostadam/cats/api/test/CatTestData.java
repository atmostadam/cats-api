package com.atmostadam.cats.api.test;

import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.Microchip;
import com.atmostadam.cats.api.model.in.CatRequest;

import java.util.UUID;

public final class CatTestData {
    private CatTestData() { }

    public static final Cat cat() {
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

    public static final  CatRequest request() {
        CatRequest request = new CatRequest();
        request.setTransactionId(UUID.randomUUID().toString());
        request.getCats().add(cat());
        return request;
    }
}
