package com.atmostadam.cats.api.rest;

import com.atmostadam.cats.api.configuration.CatConfiguration;
import com.atmostadam.cats.api.model.CatRequestTest;
import com.atmostadam.cats.api.model.CatResponseTest;
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

import java.util.List;

import static com.atmostadam.cats.api.test.CatTestValues.TEST_MICROCHIP_NUMBER;
import static com.atmostadam.cats.api.test.CatTestValues.TEST_REQUEST_ID;
import static com.atmostadam.cats.api.util.CatApiUtils.convertToJsonNode;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

        assertThat(actual.getResponse().getStatus(), Matchers.equalTo(HttpStatus.OK.value()));
        assertThat(actual.getResponse().getHeaders("requestId"), Matchers.equalTo(List.of(TEST_REQUEST_ID)));
        assertThat(actual.getResponse().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON.toString()));

        assertEquals(convertToJsonNode(om.readValue(actual.getResponse().getContentAsString(), CatResponse.class)),
                CatResponseTest.EXPECTED_NODE);
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

        assertThat(actual.getResponse().getStatus(), Matchers.equalTo(HttpStatus.OK.value()));
        assertThat(actual.getResponse().getHeaders("requestId"), Matchers.equalTo(List.of(TEST_REQUEST_ID)));
        assertThat(actual.getResponse().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON.toString()));

        assertEquals(convertToJsonNode(om.readValue(actual.getResponse().getContentAsString(), CatResponse.class)),
                CatResponseTest.EXPECTED_NODE);
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

        assertThat(actual.getResponse().getStatus(), Matchers.equalTo(HttpStatus.OK.value()));
        assertThat(actual.getResponse().getHeaders("requestId"), Matchers.equalTo(List.of(TEST_REQUEST_ID)));
        assertThat(actual.getResponse().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON.toString()));

        assertEquals(convertToJsonNode(om.readValue(actual.getResponse().getContentAsString(), CatResponse.class)),
                CatResponseTest.EXPECTED_NODE);
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

        assertThat(actual.getResponse().getStatus(), Matchers.equalTo(HttpStatus.OK.value()));
        assertThat(actual.getResponse().getHeaders("requestId"), Matchers.equalTo(List.of(TEST_REQUEST_ID)));
        assertThat(actual.getResponse().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON.toString()));

        assertEquals(convertToJsonNode(om.readValue(actual.getResponse().getContentAsString(), CatResponse.class)),
                CatResponseTest.EXPECTED_NODE);
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

        assertThat(actual.getResponse().getStatus(), Matchers.equalTo(HttpStatus.OK.value()));
        assertThat(actual.getResponse().getHeaders("requestId"), Matchers.equalTo(List.of(TEST_REQUEST_ID)));
        assertThat(actual.getResponse().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON.toString()));

        assertEquals(convertToJsonNode(om.readValue(actual.getResponse().getContentAsString(), CatResponse.class)),
                CatResponseTest.EXPECTED_NODE);
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

        assertThat(actual.getResponse().getStatus(), Matchers.equalTo(HttpStatus.OK.value()));
        assertThat(actual.getResponse().getHeaders("requestId"), Matchers.equalTo(List.of(TEST_REQUEST_ID)));
        assertThat(actual.getResponse().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON.toString()));

        assertEquals(convertToJsonNode(om.readValue(actual.getResponse().getContentAsString(), CatResponse.class)),
                CatResponseTest.EXPECTED_NODE);
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

        assertThat(actual.getResponse().getStatus(), Matchers.equalTo(HttpStatus.OK.value()));
        assertThat(actual.getResponse().getHeaders("requestId"), Matchers.equalTo(List.of(TEST_REQUEST_ID)));
        assertThat(actual.getResponse().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON.toString()));

        assertEquals(convertToJsonNode(om.readValue(actual.getResponse().getContentAsString(), CatResponse.class)),
                CatResponseTest.EXPECTED_NODE);
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

        assertThat(actual.getResponse().getStatus(), Matchers.equalTo(HttpStatus.OK.value()));
        assertThat(actual.getResponse().getHeaders("requestId"), Matchers.equalTo(List.of(TEST_REQUEST_ID)));
        assertThat(actual.getResponse().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON.toString()));

        assertEquals(convertToJsonNode(om.readValue(actual.getResponse().getContentAsString(), CatResponse.class)),
                CatResponseTest.EXPECTED_NODE);
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

        assertThat(actual.getResponse().getStatus(), Matchers.equalTo(HttpStatus.OK.value()));
        assertThat(actual.getResponse().getHeaders("requestId"), Matchers.equalTo(List.of(TEST_REQUEST_ID)));
        assertThat(actual.getResponse().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON.toString()));

        assertEquals(convertToJsonNode(om.readValue(actual.getResponse().getContentAsString(), CatResponse.class)),
                CatResponseTest.EXPECTED_NODE);
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

        assertThat(actual.getResponse().getStatus(), Matchers.equalTo(HttpStatus.OK.value()));
        assertThat(actual.getResponse().getHeaders("requestId"), Matchers.equalTo(List.of(TEST_REQUEST_ID)));
        assertThat(actual.getResponse().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON.toString()));

        assertEquals(convertToJsonNode(om.readValue(actual.getResponse().getContentAsString(), CatResponse.class)),
                CatResponseTest.EXPECTED_NODE);
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

        assertThat(actual.getResponse().getStatus(), Matchers.equalTo(HttpStatus.OK.value()));
        assertThat(actual.getResponse().getHeaders("requestId"), Matchers.equalTo(List.of(TEST_REQUEST_ID)));
        assertThat(actual.getResponse().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON.toString()));

        assertEquals(convertToJsonNode(om.readValue(actual.getResponse().getContentAsString(), CatResponse.class)),
                CatResponseTest.EXPECTED_NODE);
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

        assertThat(actual.getResponse().getStatus(), Matchers.equalTo(HttpStatus.OK.value()));
        assertThat(actual.getResponse().getHeaders("requestId"), Matchers.equalTo(List.of(TEST_REQUEST_ID)));
        assertThat(actual.getResponse().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON.toString()));

        assertEquals(convertToJsonNode(om.readValue(actual.getResponse().getContentAsString(), CatResponse.class)),
                CatResponseTest.EXPECTED_NODE);
    }
}
