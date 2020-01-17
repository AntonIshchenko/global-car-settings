package com.epam.globalcarsettings.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

  private final static Logger log = LoggerFactory.getLogger(UserRepository.class);

  @Autowired
  public UserRepository() {

  }
}
