package com.atmostadam.cats.api.rest;

import com.atmostadam.cats.api.model.Microchip;
import com.atmostadam.cats.api.model.in.CatMicrochipRequest;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.List;

import static com.atmostadam.cats.api.test.CatTestData.cat;
import static com.atmostadam.cats.api.test.CatTestData.request;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@MockitoSettings
public class CatRegistrationResourceTest {
    public static final ObjectMapper om = new ObjectMapper();

    @Mock
    CatRegistrationResource restResource;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = standaloneSetup(restResource).build();
    }

    @Test
    void queryByMicrochipNumber() throws Exception {
        CatResponse expectedResponse = new CatResponse();
        expectedResponse.setMessage("Cat Found by Microchip Number.");
        expectedResponse.setCats(List.of(cat()));

        CatMicrochipRequest request = new CatMicrochipRequest();
        Microchip microchip = new Microchip();
        microchip.setMicrochipNumber(431654132132657L);
        request.setTransactionId("SIMULATED");
        request.setMicrochip(microchip);

        when(restResource.queryByMicrochipNumber(isA(CatMicrochipRequest.class)))
                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(get("/cats/register/1.0/cat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getStatus(), equalTo(200));
        assertThat(om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class).getMessage(),
                Matchers.equalTo(expectedResponse.getMessage()));
    }

    @Test
    void addCat() throws Exception {
        CatResponse expectedResponse = new CatResponse();
        expectedResponse.setMessage("Cat Has Been Added to Database.");
        expectedResponse.setCats(List.of(cat()));

        when(restResource.addCat(isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/register/1.0/cat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(request())))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getStatus(), equalTo(200));
        assertThat(om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class).getMessage(),
                Matchers.equalTo(expectedResponse.getMessage()));
    }

    @Test
    void updateCat() throws Exception {
        CatResponse expectedResponse = new CatResponse();
        expectedResponse.setMessage("Cat Has Been Added to Database.");
        expectedResponse.setCats(List.of(cat()));

        when(restResource.updateCat(isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(patch("/cats/register/1.0/cat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(request())))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getStatus(), equalTo(200));
        assertThat(om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class).getMessage(),
                Matchers.equalTo(expectedResponse.getMessage()));
    }

    @Test
    void deleteCat() throws Exception {
        CatResponse expectedResponse = new CatResponse();
        expectedResponse.setMessage("Cat Has Been Added to Database.");
        expectedResponse.setCats(List.of(cat()));

        CatMicrochipRequest request = new CatMicrochipRequest();
        Microchip microchip = new Microchip();
        microchip.setMicrochipNumber(431654132132657L);
        request.setTransactionId("SIMULATED");
        request.setMicrochip(microchip);

        when(restResource.deleteCat(isA(CatMicrochipRequest.class)))
                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(delete("/cats/register/1.0/cat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getStatus(), equalTo(200));
        assertThat(om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class).getMessage(),
                Matchers.equalTo(expectedResponse.getMessage()));
    }
}
