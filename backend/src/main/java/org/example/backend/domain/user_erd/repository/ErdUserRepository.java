package org.example.backend.domain.user_erd.repository;

import org.example.backend.domain.user_erd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ErdUserRepository extends JpaRepository<User, UUID> {
}
