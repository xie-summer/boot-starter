package com.framework.boot.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author summer 2018/6/6 */
@RestController
public class HelloController {

  @RequestMapping("/index")
  public String index() {
    return "Spring Boot!";
  }
}
