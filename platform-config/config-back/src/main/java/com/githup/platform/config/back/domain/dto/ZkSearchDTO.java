package com.githup.platform.config.back.domain.dto;

import java.io.Serializable;

/**
 *
 */
public class ZkSearchDTO implements Serializable {
    private static final long serialVersionUID = 1626923198300100059L;

    private String environmentCode;
    private String applicationCode;

    public String getEnvironmentCode() {
        return environmentCode;
    }

    public void setEnvironmentCode(String environmentCode) {
        this.environmentCode = environmentCode;
    }

    public String getApplicationCode() {
        return applicationCode;
    }

    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode;
    }
}
