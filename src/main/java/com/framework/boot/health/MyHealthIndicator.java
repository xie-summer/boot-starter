package com.framework.boot.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/** @author summer 2018/6/6 */
@Component
public class MyHealthIndicator implements HealthIndicator {
  @Override
  public Health health() {
    // 执行一些特定的健康检查
    int errorCode = 1;
//    int errorCode = check();
    if (errorCode != 0) {
      return Health.down().withDetail("Error Code", errorCode).build();
    }
    return Health.up().build();
  }
}
