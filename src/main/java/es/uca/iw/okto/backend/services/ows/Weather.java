package es.uca.iw.okto.backend.services.ows;

public class Weather extends WeatherEntry {
  private static final long serialVersionUID = -4357687923432452130L;

  private String name;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
