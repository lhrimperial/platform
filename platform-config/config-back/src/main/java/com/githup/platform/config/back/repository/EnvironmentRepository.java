package com.githup.platform.config.back.repository;

import com.githup.platform.config.back.domain.entity.EnvironmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 *
 */
public interface EnvironmentRepository extends JpaSpecificationExecutor<EnvironmentEntity>,JpaRepository<EnvironmentEntity, Integer> {

    List<EnvironmentEntity> findByEnvironmentNameLike(String environmentName);

}
