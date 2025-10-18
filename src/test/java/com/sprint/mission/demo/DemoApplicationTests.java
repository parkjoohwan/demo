package com.sprint.mission.demo;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class DemoApplicationTests {

  @Test
  void contextLoads() {
  }

  @Test
  void test(){
    assertThat("test").isEqualTo("test");
  }

}
