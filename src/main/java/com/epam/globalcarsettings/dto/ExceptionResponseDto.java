package com.epam.globalcarsettings.dto;

public class ExceptionResponseDto {

  private final String message;
  private final Exception exception;

  public ExceptionResponseDto(String message, Exception exception) {
    this.message = message;
    this.exception = exception;
  }

  public String getMessage() {
    return message;
  }

  public Exception getException() {
    return exception;
  }
}
