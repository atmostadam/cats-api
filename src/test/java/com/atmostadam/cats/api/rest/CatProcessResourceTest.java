package com.atmostadam.cats.api.rest;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@MockitoSettings
public class CatProcessResourceTest {
    public static final ObjectMapper om = new ObjectMapper();

    @Mock
    CatProcessResource restResource;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = standaloneSetup(restResource).build();
    }

    @Test
    void treatCat() throws Exception {
        CatResponse expectedResponse = new CatResponse();
        expectedResponse.setMessage("Cat Has Been Added to Database.");
        expectedResponse.getCats().add(cat());

        when(restResource.treatCat(isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/process/1.0/cat/medical")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(request())))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getStatus(), equalTo(200));
        assertThat(om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class).getMessage(),
                Matchers.equalTo(expectedResponse.getMessage()));
    }

    @Test
    void microchipCat() throws Exception {
        CatResponse expectedResponse = new CatResponse();
        expectedResponse.setMessage("Cat Has Been Added to Database.");
        expectedResponse.getCats().add(cat());

        when(restResource.microchipCat(isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/process/1.0/cat/microchip")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(request())))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getStatus(), equalTo(200));
        assertThat(om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class).getMessage(),
                Matchers.equalTo(expectedResponse.getMessage()));
    }

    @Test
    void postPetfinderCat() throws Exception {
        CatResponse expectedResponse = new CatResponse();
        expectedResponse.setMessage("Cat Has Been Added to Database.");
        expectedResponse.getCats().add(cat());

        when(restResource.postPetfinderCat(isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/process/1.0/cat/petfinder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(request())))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getStatus(), equalTo(200));
        assertThat(om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class).getMessage(),
                Matchers.equalTo(expectedResponse.getMessage()));
    }

    @Test
    void postAdoptAPetCat() throws Exception {
        CatResponse expectedResponse = new CatResponse();
        expectedResponse.setMessage("Cat Has Been Added to Database.");
        expectedResponse.getCats().add(cat());

        when(restResource.postAdoptAPetCat(isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/process/1.0/cat/adoptapet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(request())))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getStatus(), equalTo(200));
        assertThat(om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class).getMessage(),
                Matchers.equalTo(expectedResponse.getMessage()));
    }
}
