package es.uca.iw.okto.backend.services.weather;

import org.springframework.web.client.RestTemplate;

/**
 * WeatherService
 */
public class WeatherService {

  final String url = "https://samples.openweathermap.org/data/2.5/weather?q=%s&appid=66d9c4a3e0276f8a1b324eea8e79168b";
  RestTemplate restTemplate;

  public WeatherService() {
    restTemplate = new RestTemplate();
  }

  public Weather forCityByName(String name) {
    return restTemplate.getForObject(String.format(url, name), Weather.class);
  }
}