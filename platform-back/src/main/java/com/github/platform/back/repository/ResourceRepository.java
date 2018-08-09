package com.github.platform.back.repository;

import com.github.platform.back.domain.po.ResourcePO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface ResourceRepository extends JpaRepository<ResourcePO, Integer> {
}
