package com.example.springMVC;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Конфигурация SpringMVC приложения с помощью xml файла
 */

@Controller
public class HelloController {

  @GetMapping("/")
  public String hello() {
    return "index";
  }
}
