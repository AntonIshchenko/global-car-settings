package com.epam.globalcarsettings.repository;

import com.epam.globalcarsettings.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
