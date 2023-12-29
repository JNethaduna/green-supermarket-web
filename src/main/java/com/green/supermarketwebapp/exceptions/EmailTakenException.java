package com.green.supermarketwebapp.exceptions;

public class EmailTakenException extends RuntimeException {
  public EmailTakenException(String message) {
    super(message);
  }
}
