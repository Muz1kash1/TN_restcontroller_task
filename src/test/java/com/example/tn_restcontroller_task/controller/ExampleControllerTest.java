package com.example.tn_restcontroller_task.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ExampleControllerTest {
  private final TestRestTemplate restTemplate = new TestRestTemplate();


  private final String url = "http://localhost:" + 8080 + "/example";

  @Test
  @DisplayName("Тест гет метода")
  void getMappingMethod() {
    assertEquals(
      HttpStatus.OK, restTemplate.getForEntity(url, String.class).getStatusCode());
  }

  @Test
  @DisplayName("Тест пост метода")
  void postMappingMethod() {


    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> requestEntity = new HttpEntity<>("Test Payload", headers);

    ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity,
      String.class
    );
    assertEquals(HttpStatusCode.valueOf(201), responseEntity.getStatusCode());
    assertEquals("Запостили : Test Payload", responseEntity.getBody());
  }

  @Test
  @DisplayName("Тест пут метода")
  void putMappingMethod() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> requestEntity = new HttpEntity<>("Test Payload", headers);

    ResponseEntity<String> responseEntity = restTemplate.exchange(
      url, HttpMethod.PUT, requestEntity, String.class);

    assertEquals(HttpStatusCode.valueOf(200), responseEntity.getStatusCode());
    assertEquals("Запутили : Test Payload", responseEntity.getBody());
  }

  @Test
  @DisplayName("Тест делит метода")
  void deleteMappingMethod() {
    ResponseEntity<Void> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
    assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
  }
}