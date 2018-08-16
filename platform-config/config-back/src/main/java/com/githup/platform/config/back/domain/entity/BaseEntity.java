package com.githup.platform.config.back.domain.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@MappedSuperclass
public class BaseEntity implements Serializable{
    private static final long serialVersionUID = -5677577588922630895L;


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String active;
    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        if (active == null || active == "") {
            active = "Y";
        }
        this.active = active;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
