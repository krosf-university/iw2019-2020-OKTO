package es.uca.iw.okto.backend.utils;

public class PasswordGenerator {

  public static String NUMBERS = "0123456789";

  public static String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  public static String LOWER = "abcdefghijklmnopqrstuvwxyz";


  public static String getPassword() {
    return getPassword(8);
  }

  public static String getPassword(int length) {
    return getPassword(NUMBERS + UPPER + LOWER, length);
  }

  public static String getPassword(String key, int length) {
    String pswd = "";
    for (int i = 0; i < length; i++) {
      pswd += (key.charAt((int) (Math.random() * key.length())));
    }
    return pswd;
  }
}