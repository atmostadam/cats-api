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

import static com.atmostadam.cats.api.test.CatTestData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

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
    void onboardCat() throws Exception {
        CatResponse expected = new CatResponse().message("Cat Has Been Onboarded.").addCat(cat());

        when(restResource.onboardCat(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/1.0/cat/onboard")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(request())))
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
        CatResponse expected = new CatResponse().message("Cat Has Been Transferred.").addCat(cat());

        when(restResource.transferCat(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/1.0/cat/transfer")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(request())))
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
        CatResponse expected = new CatResponse().message("Cat is now in Foster Care.").addCat(cat());

        when(restResource.fosterCat(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/1.0/cat/transfer/foster")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(request())))
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
        CatResponse expected = new CatResponse().message("Cat Has Been Adopted.").addCat(cat());

        when(restResource.adoptCat(isA(String.class), isA(CatRequest.class)))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        MvcResult mvcResult = mockMvc.perform(post("/cats/1.0/cat/adopt")
                        .header("requestId", TEST_REQUEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(request())))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        CatResponse actual = om.readValue(mvcResult.getResponse().getContentAsString(), CatResponse.class);
        assertThat(actual.getMessage(), Matchers.equalTo(expected.getMessage()));
        assertThat(actual.getStackTrace(), Matchers.equalTo(expected.getStackTrace()));
        assertThat(actual.getCats(), Matchers.equalTo(actual.getCats()));
    }
}
