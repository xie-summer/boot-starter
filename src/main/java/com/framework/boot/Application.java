package com.framework.boot;

// import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/** @author summer 2018/6/6 */
// @ImportResource //导入xml配置

@SpringBootApplication
@ComponentScan
public class Application {
  //  SpringApplication.setWebApplicationType(WebApplicationType.REACTIVE);
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
