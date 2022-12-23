package com.atmostadam.cats.api.rest;

import com.atmostadam.cats.api.model.CatRequestTest;
import com.atmostadam.cats.api.model.CatTest;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@MockitoSettings
public class CatProcessResourceTest {
    public static String TEST_REQUEST_ID = "d1e2a63e-7c43-47ba-8721-ab872640b0b1";
    public static Long TEST_MICROCHIP_NUMBER = 431654132132657L;
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
        CatResponse expected = new CatResponse().setMessage("Cat has been Treated.").addCat(CatTest.testData());

        when(restResource.treatCat(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/process/1.0/cat/medical")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(CatRequestTest.testData())))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        CatResponse actual = om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class);
        assertThat(actual.getMessage(), Matchers.equalTo(expected.getMessage()));
        assertThat(actual.getStackTrace(), Matchers.equalTo(expected.getStackTrace()));
        assertThat(actual.getCats(), Matchers.equalTo(actual.getCats()));
    }

    @Test
    void microchipCat() throws Exception {
        CatResponse expected = new CatResponse().setMessage("Cat has been microchipped.").addCat(CatTest.testData());

        when(restResource.microchipCat(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/process/1.0/cat/microchip")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(CatRequestTest.testData())))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        CatResponse actual = om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class);
        assertThat(actual.getMessage(), Matchers.equalTo(expected.getMessage()));
        assertThat(actual.getStackTrace(), Matchers.equalTo(expected.getStackTrace()));
        assertThat(actual.getCats(), Matchers.equalTo(actual.getCats()));
    }

    @Test
    void postPetfinderCat() throws Exception {
        CatResponse expected = new CatResponse().setMessage("Cat has been posted to Petfinder.").addCat(CatTest.testData());

        when(restResource.postPetfinderCat(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/process/1.0/cat/petfinder")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(CatRequestTest.testData())))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        CatResponse actual = om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class);
        assertThat(actual.getMessage(), Matchers.equalTo(expected.getMessage()));
        assertThat(actual.getStackTrace(), Matchers.equalTo(expected.getStackTrace()));
        assertThat(actual.getCats(), Matchers.equalTo(actual.getCats()));
    }

    @Test
    void postAdoptAPetCat() throws Exception {
        CatResponse expected = new CatResponse().setMessage("Cat has been posted to Adopt-a-Pet.").addCat(CatTest.testData());

        when(restResource.postAdoptAPetCat(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/process/1.0/cat/adoptapet")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(CatRequestTest.testData())))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        CatResponse actual = om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class);
        assertThat(actual.getMessage(), Matchers.equalTo(expected.getMessage()));
        assertThat(actual.getStackTrace(), Matchers.equalTo(expected.getStackTrace()));
        assertThat(actual.getCats(), Matchers.equalTo(actual.getCats()));
    }
}
