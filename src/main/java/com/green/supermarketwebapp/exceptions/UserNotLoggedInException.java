package com.green.supermarketwebapp.Exceptions;

public class UserNotLoggedInException extends RuntimeException {
  public UserNotLoggedInException(String message) {
    super(message);
  }
}
