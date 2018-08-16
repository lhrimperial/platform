package com.githup.platform.config.back.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "t_config_property")
public class PropertyEntity extends BaseEntity {
    private static final long serialVersionUID = 3482440110038419532L;

    private Integer applicationCode;
    private String propertyKey;
    private String propertyValue;

    public Integer getApplicationCode() {
        return applicationCode;
    }

    public void setApplicationCode(Integer applicationCode) {
        this.applicationCode = applicationCode;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
}
