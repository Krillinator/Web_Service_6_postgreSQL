package com.krillinator.demo6.repository;

import com.krillinator.demo6.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {

    Optional<CustomUser> findUserByUsername(String username);

}
