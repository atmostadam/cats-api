package com.atmostadam.cats.api.rest;

import com.atmostadam.cats.api.configuration.CatConfiguration;
import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.CatRequestTest;
import com.atmostadam.cats.api.model.CatResponseTest;
import com.atmostadam.cats.api.model.CatTest;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.atmostadam.cats.api.service.CatService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static com.atmostadam.cats.api.model.CatRequestTest.TEST_REQUEST_ID;
import static com.atmostadam.cats.api.model.CatResponseTest.assertMvcResult;
import static com.atmostadam.cats.api.model.CatTest.TEST_MICROCHIP_NUMBER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringJUnitConfig(CatConfiguration.class)
public class CatResourceTest {
    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    CatResource resource;

    @Mock
    CatService service;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = standaloneSetup(resource).build();
    }

    @Test
    void onboardCat() throws Exception {
        when(service.invoke(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(CatResponseTest.testData(), HttpStatus.OK));

        MvcResult actual = mockMvc.perform(post("/cats/1.0/cat/register/onboard")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(CatRequestTest.testData())))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        assertMvcResult(actual);

        assertThat(actual.getResponse().getHeaders("requestId").get(0), Matchers.equalTo(TEST_REQUEST_ID));
        assertThat(actual.getResponse().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON.toString()));

        assertThat(actual.getResponse().getStatus(), Matchers.equalTo(HttpStatus.OK.value()));

        CatResponse actualCatResponse = om.readValue(actual.getResponse().getContentAsString(), CatResponse.class);
        assertThat(actualCatResponse.getMessage(), Matchers.equalTo(CatResponseTest.testData().getMessage()));
        assertThat(actualCatResponse.getStackTrace(), Matchers.equalTo(CatResponseTest.testData().getStackTrace()));

        Cat actualCat = actualCatResponse.getCats().get(0);
        assertThat(actualCat.getMicrochipNumber(), Matchers.equalTo(TEST_MICROCHIP_NUMBER));
        assertThat(actualCat.getName(), Matchers.equalTo(CatTest.TEST_NAME));
        assertThat(actualCat.getBreed(), Matchers.equalTo(CatTest.TEST_BREED));
        assertThat(actualCat.getType(), Matchers.equalTo(CatTest.TEST_TYPE));
        assertThat(actualCat.getPrimaryColor(), Matchers.equalTo(CatTest.TEST_PRIMARY_COLOR));
        assertThat(actualCat.getSex(), Matchers.equalTo(CatTest.TEST_SEX));
        assertThat(actualCat.getAge(), Matchers.equalTo(CatTest.TEST_AGE));
        assertThat(actualCat.isDeceased(), Matchers.equalTo(CatTest.TEST_DECEASED));
        assertThat(actualCat.isNeutered(), Matchers.equalTo(CatTest.TEST_NEUTERED));
    }

    @Test
    void transferCat() throws Exception {
        when(service.invoke(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(CatResponseTest.testData(), HttpStatus.OK));

        MvcResult actual = mockMvc.perform(post("/cats/1.0/cat/register/transfer")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(CatRequestTest.testData())))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        assertMvcResult(actual);
    }

    @Test
    void fosterCat() throws Exception {
        when(service.invoke(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(CatResponseTest.testData(), HttpStatus.OK));

        MvcResult actual = mockMvc.perform(post("/cats/1.0/cat/register/transfer/foster")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(CatRequestTest.testData())))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        assertMvcResult(actual);
    }

    @Test
    void adoptCat() throws Exception {
        when(service.invoke(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(CatResponseTest.testData(), HttpStatus.OK));

        MvcResult actual = mockMvc.perform(post("/cats/1.0/cat/register/adopt")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(CatRequestTest.testData())))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        assertMvcResult(actual);
    }

    @Test
    void queryByMicrochipNumber() throws Exception {
        when(service.invoke(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(CatResponseTest.testData(), HttpStatus.OK));

        MvcResult actual = mockMvc.perform(get("/cats/1.0/cat")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(new CatRequest().addMicrochipNumber(TEST_MICROCHIP_NUMBER))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        assertMvcResult(actual);
    }

    @Test
    void addCat() throws Exception {
        when(service.invoke(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(CatResponseTest.testData(), HttpStatus.OK));

        MvcResult actual = mockMvc.perform(post("/cats/1.0/cat")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(CatRequestTest.testData())))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        assertMvcResult(actual);
    }

    @Test
    void updateCat() throws Exception {
        when(service.invoke(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(CatResponseTest.testData(), HttpStatus.OK));

        MvcResult actual = mockMvc.perform(patch("/cats/1.0/cat")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(CatRequestTest.testData())))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        assertMvcResult(actual);
    }

    @Test
    void deleteCat() throws Exception {
        when(service.invoke(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(CatResponseTest.testData(), HttpStatus.OK));

        MvcResult actual = mockMvc.perform(delete("/cats/1.0/cat")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(new CatRequest().addMicrochipNumber(TEST_MICROCHIP_NUMBER))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        assertMvcResult(actual);
    }

    @Test
    void treatCat() throws Exception {
        when(service.invoke(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(CatResponseTest.testData(), HttpStatus.OK));

        MvcResult actual = mockMvc.perform(post("/cats/1.0/cat/process/medical")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(CatRequestTest.testData())))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        assertMvcResult(actual);
    }

    @Test
    void microchipCat() throws Exception {
        when(service.invoke(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(CatResponseTest.testData(), HttpStatus.OK));

        MvcResult actual = mockMvc.perform(post("/cats/1.0/cat/process/microchip")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(CatRequestTest.testData())))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        assertMvcResult(actual);
    }

    @Test
    void postPetfinderCat() throws Exception {
        when(service.invoke(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(CatResponseTest.testData(), HttpStatus.OK));

        MvcResult actual = mockMvc.perform(post("/cats/1.0/cat/process/petfinder")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(CatRequestTest.testData())))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        assertMvcResult(actual);
    }

    @Test
    void postAdoptAPetCat() throws Exception {
        when(service.invoke(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(CatResponseTest.testData(), HttpStatus.OK));

        MvcResult actual = mockMvc.perform(post("/cats/1.0/cat/process/adoptapet")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(CatRequestTest.testData())))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        assertMvcResult(actual);
    }
}
