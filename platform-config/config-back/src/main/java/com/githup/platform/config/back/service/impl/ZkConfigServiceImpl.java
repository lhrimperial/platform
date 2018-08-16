package com.githup.platform.config.back.service.impl;

import com.github.framework.util.string.StringUtils;
import com.githup.platform.config.back.domain.entity.ApplicationEntity;
import com.githup.platform.config.back.domain.entity.EnvironmentEntity;
import com.githup.platform.config.back.repository.ApplicationRepository;
import com.githup.platform.config.back.repository.EnvironmentRepository;
import com.githup.platform.config.back.service.IZkConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class ZkConfigServiceImpl implements IZkConfigService {

    @Autowired
    private EnvironmentRepository environmentRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<EnvironmentEntity> remoteMethodEnv(String environmentName) {
        return environmentRepository.findByEnvironmentNameLike("%"+environmentName+"%");
    }

    @Override
    public Page<EnvironmentEntity> findEnvByPage(final EnvironmentEntity environmentEntity, Pageable pageable) {
        return environmentRepository.findAll(new Specification<EnvironmentEntity>() {

            @Override
            public Predicate toPredicate(Root<EnvironmentEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if(!StringUtils.isEmpty(environmentEntity.getEnvironmentCode())) {
                    Path<String> environmentCode = root.get("environmentCode");
                    list.add(criteriaBuilder.equal(environmentCode, environmentEntity.getEnvironmentCode()));
                }
                if(!StringUtils.isEmpty(environmentEntity.getEnvironmentName())) {
                    Path<String> environmentName = root.get("environmentName");
                    list.add(criteriaBuilder.like(environmentName, "%"+environmentEntity.getEnvironmentName()+"%"));
                }

                Predicate[] predicates = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(predicates));
            }
        }, pageable);
    }

    @Override
    public EnvironmentEntity saveOrUpdateEnv(EnvironmentEntity environmentEntity) {
        return environmentRepository.save(environmentEntity);
    }

    @Override
    public void deleteEnv(Integer envId) {
        environmentRepository.delete(envId);
    }

    @Override
    public List<ApplicationEntity> remoteMethodApp(String environmentCode, String applicationName) {
        return applicationRepository.findByApplicationNameLike(environmentCode, applicationName);
    }

    @Override
    public Page<ApplicationEntity> findAppByPage(final ApplicationEntity applicationEntity, Pageable pageable) {
        return applicationRepository.findAll(new Specification<ApplicationEntity>() {

                    @Override
                    public Predicate toPredicate(Root<ApplicationEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                        List<Predicate> list = new ArrayList<Predicate>();
                        if (!StringUtils.isEmpty(applicationEntity.getEnvironmentCode())) {
                            Path<String> environmentCode = root.get("environmentCode");
                            list.add(criteriaBuilder.equal(environmentCode, applicationEntity.getEnvironmentCode()));
                        }
                        if (!StringUtils.isEmpty(applicationEntity.getApplicationCode())) {
                            Path<String> applicationCode = root.get("applicationCode");
                            list.add(criteriaBuilder.equal(applicationCode, applicationEntity.getApplicationCode()));
                        }
                        if (!StringUtils.isEmpty(applicationEntity.getApplicationName())) {
                            Path<String> applicationName = root.get("applicationName");
                            list.add(criteriaBuilder.like(applicationName, "%" + applicationEntity.getApplicationName() + "%"));
                        }

                        Predicate[] predicates = new Predicate[list.size()];
                        return criteriaBuilder.and(list.toArray(predicates));
                    }
                }, pageable);
    }

    @Override
    public ApplicationEntity saveOrUpdateApp(ApplicationEntity applicationEntity) {
        return applicationRepository.save(applicationEntity);
    }

    @Override
    public void deleteApp(Integer appId) {
        applicationRepository.delete(appId);
    }
}
