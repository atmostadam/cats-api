package com.atmostadam.cats.api.model;

import javax.validation.constraints.Max;
import java.util.List;

/**
 *
 * @author Adam Johnston, Rachel Johnston
 */
public class Cage {
    private String id;
    private int height;
    private int width;
    private int depth;
    @Max(10)
    private int maxCats;
    private boolean builtInToys;
    private boolean builtInLitterbox;
    private boolean builtInFood;
    private boolean builtInWater;
    private List<Cage> connections;
}
