package com.example.tn_restcontroller_task.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;

/**
 * Класс для задания по контроллерам
 */
@RestController
@RequestMapping("/example")
public class ExampleController {
  /**
   * Контроллер гет метода
   *
   * @return строка с возвратом для примера
   */
  @GetMapping
  ResponseEntity<String> getMappingMethod() {
    return ResponseEntity.ok("Возврат с гета");
  }

  /**
   * Контроллер пост метода
   *
   * @param payload нагрузка приходящая на контроллер
   * @return строка с возвратом для примера использующая пришедшую нагрузку
   */
  @PostMapping
  ResponseEntity<String> postMappingMethod(@RequestBody String payload) {
    return ResponseEntity.created(URI.create("example")).body("Запостили : " + payload);
  }

  /**
   * Контроллер пут метода
   *
   * @param payload нагрузка приходящая на контроллер
   * @return строка с возвратом для примера использующая пришедшую нагрузку
   */
  @PutMapping
  ResponseEntity<String> putMappingMethod(@RequestBody String payload) {
    return ResponseEntity.ok("Запутили : " + payload);
  }

  /**
   * Контроллер делит метода
   *
   * @return пустой запрос с статусом no content
   */
  @DeleteMapping
  ResponseEntity<Void> deleteMappingMethod() {
    return ResponseEntity.noContent().build();
  }

}
