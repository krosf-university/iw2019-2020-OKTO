package es.uca.iw.okto.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public interface HasLogger {

  default Logger getLogger() {
    return LoggerFactory.getLogger(getClass());
  }
}
