package com.atmostadam.cats.api.rest;

import com.atmostadam.cats.api.rest.CatResource;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@MockitoSettings
class CatResourceTest {
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
        MvcResult mvcResult = mockMvc.perform(get("/cats/1.0/id/" + microchipNumber)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        assertThat(mvcResult.getResponse().getStatus(), equalTo(200));
        assertThat(mvcResult.getResponse().getContentAsString(), Matchers.equalTo(""));
    }
}
