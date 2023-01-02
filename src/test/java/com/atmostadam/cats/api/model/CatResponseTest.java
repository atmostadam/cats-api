package com.atmostadam.cats.api.model;

import com.atmostadam.cats.api.model.out.CatResponse;
import com.fasterxml.jackson.databind.JsonNode;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static com.atmostadam.cats.api.util.CatDefaultValues.*;
import static com.atmostadam.cats.api.util.CatApiUtils.convertToJsonNode;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatResponseTest {
    public static final CatResponse EXPECTED = testData();
    public static final JsonNode EXPECTED_NODE = convertToJsonNode(testData());

    public static final CatResponse testData() {
        return new CatResponse()
                .setMessage(TEST_MESSAGE)
                .setStackTrace(TEST_STACK_TRACE)
                .addCat(CatTest.EXPECTED);
    }

    @Test
    void catResponse() {
        CatResponse actual = new CatResponse()
                .setMessage(TEST_MESSAGE)
                .setStackTrace(TEST_STACK_TRACE)
                .addCat(CatTest.EXPECTED);
        assertEquals(EXPECTED_NODE, convertToJsonNode(actual));
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

        assertEquals(EXPECTED_NODE, convertToJsonNode(actual.getBody()));
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

        assertEquals(EXPECTED_NODE, convertToJsonNode(actual.getBody()));
    }
}
