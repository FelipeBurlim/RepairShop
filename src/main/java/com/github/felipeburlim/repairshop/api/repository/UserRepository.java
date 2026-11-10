package com.github.felipeburlim.repairshop.api.repository;

import com.github.felipeburlim.repairshop.api.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByLogin(String login);
}
