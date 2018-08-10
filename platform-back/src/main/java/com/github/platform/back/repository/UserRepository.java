package com.github.platform.back.repository;

import com.github.platform.back.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
