package com.github.platform.back.domain.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
@Entity
@Table(name = "t_resource")
public class ResourceEntity extends BaseEntity {
    private static final long serialVersionUID = -325754276851615269L;

    private String resCode;
    private String parentCode;
    private String index;
    private String title;
    private String path;
    private String icon;
    private Integer level;
    private Integer type;

    @ManyToMany(mappedBy = "resourcePOS", fetch = FetchType.EAGER)
    private Set<RoleEntity> rolePOS = new HashSet<>();

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="parentCode", referencedColumnName="resCode", insertable = false, updatable = false)
    private ResourceEntity parentResource;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="parentResource")
    private List<ResourceEntity> children = new ArrayList<>();

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Set<RoleEntity> getRolePOS() {
        return rolePOS;
    }

    public void setRolePOS(Set<RoleEntity> rolePOS) {
        this.rolePOS = rolePOS;
    }

    public ResourceEntity getParentResource() {
        return parentResource;
    }

    public void setParentResource(ResourceEntity parentResource) {
        this.parentResource = parentResource;
    }

    public List<ResourceEntity> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceEntity> children) {
        this.children = children;
    }
}
