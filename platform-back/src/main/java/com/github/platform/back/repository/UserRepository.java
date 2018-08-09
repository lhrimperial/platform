package com.github.platform.back.repository;

import com.github.platform.back.domain.po.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 */
public interface UserRepository extends JpaRepository<UserPO, Integer> {
}
