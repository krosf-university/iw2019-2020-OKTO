package es.uca.iw.okto.backend.security;

import es.uca.iw.okto.backend.models.User;

@FunctionalInterface
public interface CurrentUser {

  User getUser();
}
