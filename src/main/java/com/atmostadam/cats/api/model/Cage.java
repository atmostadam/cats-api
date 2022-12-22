package com.atmostadam.cats.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import java.util.List;

/**
 *
 * @author Adam Johnston, Rachel Johnston
 */
@Getter
@Setter
@Accessors(fluent = false, chain = true)
public class Cage {
    private String id;
    private int height;
    private int width;
    private int depth;
    private int numOfShelves;
    @Max(10)
    private int maxCats;
    private boolean builtInToys;
    private boolean builtInLitterbox;
    private boolean builtInFood;
    private boolean builtInWater;
    private boolean builtInBed;
    private List<Cage> connections;
}
