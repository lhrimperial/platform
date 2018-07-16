package com.github.platform.back.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class SearchVO implements Serializable{
    private Long batchId;
    private Long productId;
    private String productName;
    private Long goodsId;
    private String goodsName;
    private String batchStatus;
    private Date createBefore;
    private Date createAfter;
    private Integer pageSize;
    private Integer currentPage;

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }

    public Date getCreateBefore() {
        return createBefore;
    }

    public void setCreateBefore(Date createBefore) {
        this.createBefore = createBefore;
    }

    public Date getCreateAfter() {
        return createAfter;
    }

    public void setCreateAfter(Date createAfter) {
        this.createAfter = createAfter;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
