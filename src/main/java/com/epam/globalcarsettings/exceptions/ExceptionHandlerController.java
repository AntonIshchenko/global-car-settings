package com.epam.globalcarsettings.exceptions;

import com.epam.globalcarsettings.dto.ExceptionResponseDto;
import com.epam.globalcarsettings.util.ExceptionMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionHandlerController {

  private static final Logger log = LoggerFactory.getLogger(ExceptionHandlerController.class);

  private final ExceptionMessageHandler exceptionMessageHandler;

  @Autowired
  public ExceptionHandlerController(ExceptionMessageHandler exceptionMessageHandler) {
    this.exceptionMessageHandler = exceptionMessageHandler;
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  ExceptionResponseDto exceptionHandler(Exception exception) {
    return getExceptionResponseDto(exception);
  }

  ExceptionResponseDto getExceptionResponseDto(Exception exception) {
    String exceptionMessage = exception.getMessage();
    if (exceptionMessage == null) {
      exceptionMessage = exceptionMessageHandler.getLocalizedMessage("no_message_specified");
    }
    log.error(exceptionMessage, exception);
    return new ExceptionResponseDto(exceptionMessage, exception);
  }
}
