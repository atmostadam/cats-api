package com.atmostadam.cats.api.model;

import com.atmostadam.cats.api.model.out.CatResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static com.atmostadam.cats.api.model.CatTest.assertCat;
import static org.hamcrest.MatcherAssert.assertThat;

public class CatResponseTest {
    private static final ObjectMapper om = new ObjectMapper();

    public static final CatResponse testData() {
        return new CatResponse().setMessage("12345").addCats(List.of(CatTest.testData(),
                CatTest.testData(), CatTest.testData()));
    }

    public static final void assertMvcResult(MvcResult result) throws Exception {
        assertThat(result.getResponse().getHeaders("requestId").get(0), Matchers.equalTo(CatRequestTest.TEST_REQUEST_ID));
        assertThat(result.getResponse().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON.toString()));
        assertThat(result.getResponse().getStatus(), Matchers.equalTo(HttpStatus.OK.value()));
        assertCatResponse(om.readValue(result.getResponse().getContentAsString(), CatResponse.class));
    }

    public static final void assertCatResponse(CatResponse response) {
        assertThat(response.getMessage(), Matchers.equalTo(CatResponseTest.testData().getMessage()));
        assertThat(response.getStackTrace(), Matchers.equalTo(CatResponseTest.testData().getStackTrace()));
        assertCat(response.getCats().get(0));
    }

    @Test
    void addCats() {
        CatResponse actual = new CatResponse().addCats(List.of(CatTest.testData(),
                CatTest.testData(), CatTest.testData()));
        assertThat(actual.getCats().size(), Matchers.equalTo(3));
    }

    @Test
    void addCat() {
        CatResponse actual = new CatResponse().addCat(CatTest.testData());
        assertThat(actual.getCats().size(), Matchers.equalTo(1));
    }

    @Test
    void setException() {
        Exception e = new RuntimeException("Simulated");
        CatResponse actual = new CatResponse().addCats(List.of(CatTest.testData(),
                CatTest.testData(), CatTest.testData()))
                .setException(e);
        assertThat(actual.getMessage(),Matchers.equalTo("Simulated"));
    }

    @Test
    void newResponseEntity() {
        ResponseEntity<CatResponse> actual = testData().newResponseEntity(CatRequestTest.TEST_REQUEST_ID, HttpStatus.OK);
        assertThat(actual.getStatusCode(), Matchers.equalTo(HttpStatus.OK));
        assertThat(actual.getHeaders().get("requestId"), Matchers.equalTo(List.of(CatRequestTest.TEST_REQUEST_ID)));
        assertThat(actual.getHeaders().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON));
        assertThat(actual.getBody().getMessage(), Matchers.equalTo("12345"));
        assertThat(actual.getBody().getCats().size(), Matchers.equalTo(3));
    }

    @Test
    void newResponseEntityMultipleHeaders() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put("requestId", List.of(CatRequestTest.TEST_REQUEST_ID));
        headers.put("Content-Type", List.of(MediaType.APPLICATION_JSON.toString()));
        ResponseEntity<CatResponse> actual = testData().newResponseEntity(headers, HttpStatus.OK);
        assertThat(actual.getStatusCode(), Matchers.equalTo(HttpStatus.OK));
        assertThat(actual.getHeaders().get("requestId"), Matchers.equalTo(List.of(CatRequestTest.TEST_REQUEST_ID)));
        assertThat(actual.getHeaders().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON));
        assertThat(actual.getBody().getMessage(), Matchers.equalTo("12345"));
        assertThat(actual.getBody().getCats().size(), Matchers.equalTo(3));
    }
}
