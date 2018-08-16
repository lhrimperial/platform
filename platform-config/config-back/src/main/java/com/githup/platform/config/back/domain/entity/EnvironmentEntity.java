package com.githup.platform.config.back.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "t_config_environment")
public class EnvironmentEntity extends BaseEntity {
    private static final long serialVersionUID = 1941492992332764639L;

    private String environmentCode;
    private String environmentName;

    public String getEnvironmentCode() {
        return environmentCode;
    }

    public void setEnvironmentCode(String environmentCode) {
        this.environmentCode = environmentCode;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }
}
