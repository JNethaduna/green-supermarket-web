package com.green.supermarketwebapp.exceptions;

public class UserNotLoggedInException extends RuntimeException {
  public UserNotLoggedInException(String message) {
    super(message);
  }
}
