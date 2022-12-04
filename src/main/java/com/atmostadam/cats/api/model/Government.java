package com.atmostadam.cats.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * A JSON object that represents the government agency that will be taking care of the cat.
 * <br/>
 * Examples include Animal Control, Department of Natural Resources, Police (Confiscation).
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
//@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Government {


}
