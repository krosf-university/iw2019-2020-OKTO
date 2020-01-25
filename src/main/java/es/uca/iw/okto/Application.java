package es.uca.iw.okto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import es.uca.iw.okto.backend.services.ows.WeatherProperties;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@EnableConfigurationProperties(WeatherProperties.class)
@EnableJpaRepositories()
@EnableCaching(proxyTargetClass = true)
public class Application extends SpringBootServletInitializer {

  public static void main(String[] argv) {
    SpringApplication.run(Application.class, argv);
  }
}
