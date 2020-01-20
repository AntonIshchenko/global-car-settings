package com.epam.globalcarsettings.util;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class ExceptionMessageHandler {
  private final MessageSource messageSource;

  public ExceptionMessageHandler(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  public String getLocalizedMessage(String property, Object... parameters) {
    return messageSource.getMessage(property, parameters, LocaleContextHolder.getLocale());
  }
}
