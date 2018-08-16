package com.githup.platform.common.domain.dto;

import java.io.Serializable;

/**
 *
 */
public class RequestDTO<T> implements Serializable{
    private static final long serialVersionUID = 7136285877622675592L;
    private Integer pageNo;
    private Integer pageSize;
    private T request;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public T getRequest() {
        return request;
    }

    public void setRequest(T request) {
        this.request = request;
    }
}
