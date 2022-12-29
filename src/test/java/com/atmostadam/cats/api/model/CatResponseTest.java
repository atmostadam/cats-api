package com.atmostadam.cats.api.model;

import com.atmostadam.cats.api.model.out.CatResponse;
import com.atmostadam.cats.api.test.CatTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class CatResponseTest {
    public static final String TEST_REQUEST_ID = "d1e2a63e-7c43-47ba-8721-ab872640b0b1";

    public static final CatResponse testData() {
        return new CatResponse().setMessage("12345").addCats(List.of(CatTest.testData(),
                CatTest.testData(), CatTest.testData()));
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
        ResponseEntity<CatResponse> actual = testData().newResponseEntity(TEST_REQUEST_ID, HttpStatus.OK);
        assertThat(actual.getStatusCode(), Matchers.equalTo(HttpStatus.OK));
        assertThat(actual.getHeaders().get("requestId"), Matchers.equalTo(List.of(TEST_REQUEST_ID)));
        assertThat(actual.getHeaders().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON));
        assertThat(actual.getBody().getMessage(), Matchers.equalTo("12345"));
        assertThat(actual.getBody().getCats().size(), Matchers.equalTo(3));
    }

    @Test
    void newResponseEntityMultipleHeaders() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put("requestId", List.of(TEST_REQUEST_ID));
        headers.put("Content-Type", List.of(MediaType.APPLICATION_JSON.toString()));
        ResponseEntity<CatResponse> actual = testData().newResponseEntity(headers, HttpStatus.OK);
        assertThat(actual.getStatusCode(), Matchers.equalTo(HttpStatus.OK));
        assertThat(actual.getHeaders().get("requestId"), Matchers.equalTo(List.of(TEST_REQUEST_ID)));
        assertThat(actual.getHeaders().getContentType(), Matchers.equalTo(MediaType.APPLICATION_JSON));
        assertThat(actual.getBody().getMessage(), Matchers.equalTo("12345"));
        assertThat(actual.getBody().getCats().size(), Matchers.equalTo(3));
    }
}
