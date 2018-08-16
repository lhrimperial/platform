package com.githup.platform.config.back.service;

import com.githup.platform.config.back.domain.entity.ApplicationEntity;
import com.githup.platform.config.back.domain.entity.EnvironmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *
 */
public interface IZkConfigService {

    List<EnvironmentEntity> remoteMethodEnv(String environmentName);

    Page<EnvironmentEntity> findEnvByPage(EnvironmentEntity environmentEntity, Pageable pageable);

    EnvironmentEntity saveOrUpdateEnv(EnvironmentEntity environmentEntity);

    void deleteEnv(Integer envId);

    List<ApplicationEntity> remoteMethodApp(String environmentCode,String applicationName);


    Page<ApplicationEntity> findAppByPage(ApplicationEntity applicationEntity, Pageable pageable);

    ApplicationEntity saveOrUpdateApp(ApplicationEntity applicationEntity);

    void deleteApp(Integer appId);
}
