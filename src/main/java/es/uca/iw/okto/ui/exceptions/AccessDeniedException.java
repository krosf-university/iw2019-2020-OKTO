package es.uca.iw.okto.ui.exceptions;

public class AccessDeniedException extends RuntimeException {
  private static final long serialVersionUID = -6687378173750097820L;

  public AccessDeniedException() {
  }

  public AccessDeniedException(String message) {
    super(message);
  }
}
