package com.githup.platform.config.back.repository;

import com.githup.platform.config.back.domain.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 *
 */
public interface ApplicationRepository extends JpaSpecificationExecutor<ApplicationEntity>,JpaRepository<ApplicationEntity, Integer>{

    @Query("select app from ApplicationEntity app where app.environmentCode = ?1 and app.applicationName like concat('%',concat(?2,'%')) " )
    List<ApplicationEntity> findByApplicationNameLike(String environmentCode, String applicationName);
}
