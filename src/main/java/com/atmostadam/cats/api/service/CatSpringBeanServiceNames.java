package com.atmostadam.cats.api.service;

import java.util.List;

public final class CatSpringBeanServiceNames {
    private CatSpringBeanServiceNames() {}

    public static final String ONBOARD_CAT = "onboardCat";
    public static final String TRANSFER_CAT = "transferCat";
    public static final String FOSTER_CAT =  "fosterCat";
    public static final String ADOPT_CAT = "adoptCat";
    public static final String QUERY_BY_MICROSERVICE_NUMBER = "queryByMicrochipNumber";
    public static final String ADD_CAT = "addCat";
    public static final String UPDATE_CAT = "updateCat";
    public static final String DELETE_CAT = "deleteCat";
    public static final String TREAT_CAT = "treatCat";
    public static final String MICROCHIP_CAT = "microchipCat";
    public static final String POST_PETFINDER_CAT = "postPetfinderCat";
    public static final String POST_ADOPT_A_PET_CAT = "postAdoptAPetCat";
    public static final List<String> SERVICE_NAMES = List.of(ONBOARD_CAT,
            TRANSFER_CAT,
            FOSTER_CAT,
            ADOPT_CAT,
            QUERY_BY_MICROSERVICE_NUMBER,
            ADD_CAT,
            UPDATE_CAT,
            DELETE_CAT,
            TREAT_CAT,
            MICROCHIP_CAT,
            POST_PETFINDER_CAT,
            POST_ADOPT_A_PET_CAT);
    public static final String SERVICE_MAP = "serviceMap";
}
