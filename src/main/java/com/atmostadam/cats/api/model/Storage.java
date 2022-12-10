package com.atmostadam.cats.api.model;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adam Johnston, Rachel Johnston
 */
public class Storage {
    @Max(500)
    List<Cage> cages = new ArrayList<>();
}
