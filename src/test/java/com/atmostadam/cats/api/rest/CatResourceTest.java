package com.atmostadam.cats.api.rest;

import com.atmostadam.cats.api.model.Cat;
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
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/** Tests with sample data and validation annotations can be found in cats-test. */
@MockitoSettings
class CatResourceTest {
    public static final ObjectMapper om = new ObjectMapper();

    @Mock
    CatResource restResource;

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

        when(restResource.queryByMicrochipNumber(431654132132657L))
                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(get("/cats/1.0/cat/431654132132657")
                        .contentType(MediaType.APPLICATION_JSON))
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

        when(restResource.addCat(anyLong(), any(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/1.0/cat/431654132132657")
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

        when(restResource.updateCat(anyLong(), any(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(patch("/cats/1.0/cat/431654132132657")
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

        when(restResource.deleteCat(431654132132657L))
                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(delete("/cats/1.0/cat/431654132132657")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getStatus(), equalTo(200));
        assertThat(om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class).getMessage(),
                Matchers.equalTo(expectedResponse.getMessage()));
    }

    private Cat cat() {
        Cat cat = new Cat();
        cat.setMicrochipNumber(431654132132657L);
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

    private CatRequest request() {
        CatRequest request = new CatRequest();
        request.setId(UUID.randomUUID().toString());
        request.getCats().add(cat());
        return request;
    }
}
