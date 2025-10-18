package com.sprint.mission.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sprint.mission.demo.controller.TestController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TestController.class)
@AutoConfigureMockMvc
@ImportAutoConfiguration(exclude = {
    HibernateJpaAutoConfiguration.class,
    JpaRepositoriesAutoConfiguration.class
})
class TestControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void test() throws Exception {
    mockMvc.perform(get("/api/test"))
           .andExpect(status().isOk())
           .andExpect(result ->
               Assertions.assertThat(result.getResponse()
                                           .getContentAsString())
                         .isEqualTo("test"));
  }
}
