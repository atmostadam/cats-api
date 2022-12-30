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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@MockitoSettings
class CatResourceMockTest {
    public static String TEST_REQUEST_ID = "d1e2a63e-7c43-47ba-8721-ab872640b0b1";
    public static Long TEST_MICROCHIP_NUMBER = 431654132132657L;
    public static final ObjectMapper om = new ObjectMapper();

    @Mock
    CatResource restResource;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = standaloneSetup(restResource).build();
    }

    @Test
    void onboardCat() throws Exception {
        CatResponse expected = new CatResponse().setMessage("Cat Has Been Onboarded.").addCat(CatTest.testData());

        when(restResource.onboardCat(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/1.0/cat/register/onboard")
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
    void transferCat() throws Exception {
        CatResponse expected = new CatResponse().setMessage("Cat Has Been Transferred.").addCat(CatTest.testData());

        when(restResource.transferCat(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/1.0/cat/register/transfer")
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
    void fosterCat() throws Exception {
        CatResponse expected = new CatResponse().setMessage("Cat is now in Foster Care.").addCat(CatTest.testData());

        when(restResource.fosterCat(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/1.0/cat/register/transfer/foster")
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
    void adoptCat() throws Exception {
        CatResponse expected = new CatResponse().setMessage("Cat Has Been Adopted.").addCat(CatTest.testData());

        when(restResource.adoptCat(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/1.0/cat/register/adopt")
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
    void queryByMicrochipNumber() throws Exception {
        CatResponse expected = new CatResponse().setMessage("Cat Found by Microchip Number.").addCat(CatTest.testData());

        when(restResource.queryByMicrochipNumber(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(get("/cats/1.0/cat")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(new CatRequest().addMicrochipNumber(TEST_MICROCHIP_NUMBER))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        CatResponse actual = om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class);
        assertThat(actual.getMessage(), Matchers.equalTo(expected.getMessage()));
        assertThat(actual.getStackTrace(), Matchers.equalTo(expected.getStackTrace()));
        assertThat(actual.getCats(), Matchers.equalTo(actual.getCats()));
    }

    @Test
    void addCat() throws Exception {
        CatResponse expected = new CatResponse().setMessage("Cat Has Been Added to Database.").addCat(CatTest.testData());

        when(restResource.addCat(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/1.0/cat")
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
    void updateCat() throws Exception {
        CatResponse expected = new CatResponse().setMessage("Cat Has Been Updated in the Database.").addCat(CatTest.testData());

        when(restResource.updateCat(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(patch("/cats/1.0/cat")
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
    void deleteCat() throws Exception {
        CatResponse expected = new CatResponse().setMessage("Cat Has Been Deleted From the Database.").addCat(CatTest.testData());

        when(restResource.deleteCat(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(delete("/cats/1.0/cat")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(new CatRequest().addMicrochipNumber(TEST_MICROCHIP_NUMBER))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        CatResponse actual = om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class);
        assertThat(actual.getMessage(), Matchers.equalTo(expected.getMessage()));
        assertThat(actual.getStackTrace(), Matchers.equalTo(expected.getStackTrace()));
        assertThat(actual.getCats(), Matchers.equalTo(actual.getCats()));
    }

    @Test
    void treatCat() throws Exception {
        CatResponse expected = new CatResponse().setMessage("Cat has been Treated.").addCat(CatTest.testData());

        when(restResource.treatCat(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/1.0/cat/process/medical")
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

        MvcResult mvcResult = mockMvc.perform(post("/cats/1.0/cat/process/microchip")
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

        MvcResult mvcResult = mockMvc.perform(post("/cats/1.0/cat/process/petfinder")
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

        MvcResult mvcResult = mockMvc.perform(post("/cats/1.0/cat/process/adoptapet")
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
