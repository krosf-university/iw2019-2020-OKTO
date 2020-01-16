package es.uca.iw.okto.backend.services.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Weather
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
  private String name;
  private Integer visibility;
  private Main main;
  private Wind wind;

  public Weather() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getVisibility() {
    return visibility;
  }

  public void setVisibility(Integer visibility) {
    this.visibility = visibility;
  }

  public Main getMain() {
    return main;
  }

  public void setMain(Main main) {
    this.main = main;
  }

  public Wind getWind() {
    return wind;
  }

  public void setWind(Wind wind) {
    this.wind = wind;
  }
}