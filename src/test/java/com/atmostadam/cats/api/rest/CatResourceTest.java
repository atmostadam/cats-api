package com.atmostadam.cats.api.rest;

import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.security.SecureRandom;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/** Tests with sample data and validation annotations can be found in cats-test. */
@MockitoSettings
class CatResourceTest {
    public static final ObjectMapper om = new ObjectMapper();

    Faker faker = Faker.instance();

    @Mock
    CatResource restResource;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = standaloneSetup(restResource).build();
    }

    @Test
    void queryByMicrochipNumber() throws Exception {
        String microchipNumber = "431654132132657";

        CatResponse expectedResponse = new CatResponse();
        expectedResponse.setMessage("Cat Found by Microchip Number.");
        expectedResponse.setCats(List.of(testDataCat()));

        when(restResource.queryByMicrochipNumber(microchipNumber))
                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(get("/cats/1.0/cat/" + microchipNumber)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getStatus(), equalTo(200));
        assertThat(om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class).getMessage(),
                Matchers.equalTo(expectedResponse.getMessage()));
    }

    @Test
    void queryByMicrochipNumberNotFound() throws Exception {
        String microchipNumber = "431654132132657";

        CatResponse expectedResponse = new CatResponse();
        expectedResponse.setMessage("Microchip Not Found in Database.");

        when(restResource.queryByMicrochipNumber(microchipNumber))
                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.NOT_FOUND));

        MvcResult mvcResult = mockMvc.perform(get("/cats/1.0/cat/" + microchipNumber)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();

        assertThat(mvcResult.getResponse().getStatus(), equalTo(404));
        assertThat(om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class).getMessage(),
                Matchers.equalTo(expectedResponse.getMessage()));
    }

    @Test
    void addCat() throws Exception {
        String microchipNumber = "431654132132657";

        CatResponse expectedResponse = new CatResponse();
        expectedResponse.setMessage("Cat Has Been Added to Database.");
        expectedResponse.setCats(List.of(new Cat()));

        CatRequest request = new CatRequest();
        request.setCats(List.of(testDataCat()));

        when(restResource.addCat(anyString(), any(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/1.0/cat/" + microchipNumber)
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getStatus(), equalTo(200));
        assertThat(om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class).getMessage(),
                Matchers.equalTo(expectedResponse.getMessage()));
    }

    @Test
    void updateCat() throws Exception {
        String microchipNumber = "431654132132657";

        CatResponse expectedResponse = new CatResponse();
        expectedResponse.setMessage("Cat Has Been Added to Database.");
        expectedResponse.setCats(List.of(new Cat()));

        CatRequest request = new CatRequest();

        when(restResource.updateCat(anyString(), any(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(patch("/cats/1.0/cat/" + microchipNumber)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getStatus(), equalTo(200));
        assertThat(om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class).getMessage(),
                Matchers.equalTo(expectedResponse.getMessage()));
    }

    @Test
    void deleteCat() throws Exception {
        String microchipNumber = "431654132132657";

        CatResponse expectedResponse = new CatResponse();
        expectedResponse.setMessage("Cat Has Been Added to Database.");
        expectedResponse.setCats(List.of(testDataCat()));

        when(restResource.deleteCat(microchipNumber))
                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));
        MvcResult mvcResult = mockMvc.perform(delete("/cats/1.0/cat/" + microchipNumber)

                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getStatus(), equalTo(200));
        assertThat(om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class).getMessage(),
                Matchers.equalTo(expectedResponse.getMessage()));
    }

    private CatRequest testDataCatRequest() {
        CatRequest request = new CatRequest();
        request.setCats(List.of(testDataCat()));
        return request;
    }

    private Cat testDataCat() {
        Cat cat = new Cat();
        cat.setMicrochipNumber(new SecureRandom().nextLong(9,15));
        cat.setName(faker.cat().name());
        cat.setBreed(faker.cat().breed());
        cat.setType("Calico");
        cat.setPrimaryColor("Orange");
        cat.setSex("M");
        cat.setAge(new SecureRandom().nextInt(0, 2));
        cat.setDeceased(false);
        cat.setNeutered(true);
        return cat;
    }
}
