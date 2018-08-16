package com.githup.platform.config.back.repository;

import com.githup.platform.config.back.domain.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface PropertyRepository extends JpaRepository<PropertyEntity, Integer> {
}
