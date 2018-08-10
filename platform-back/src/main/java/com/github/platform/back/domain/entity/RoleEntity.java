package com.github.platform.back.domain.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Entity
@Table(name = "t_role")
public class RoleEntity extends BaseEntity {
    private static final long serialVersionUID = 7888953088364381562L;

    private String roleCode;
    private String roleName;

    @ManyToMany(mappedBy = "rolePOS", fetch = FetchType.EAGER)
    private Set<UserEntity> userPOS = new HashSet<>();

    @JoinTable(name = "t_role_resource",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "resource_id", referencedColumnName = "id")})
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ResourceEntity> resourcePOS = new HashSet<>();

    public Set<ResourceEntity> getResourcePOS() {
        return resourcePOS;
    }

    public void setResourcePOS(Set<ResourceEntity> resourcePOS) {
        this.resourcePOS = resourcePOS;
    }

    public Set<UserEntity> getUserPOS() {
        return userPOS;
    }

    public void setUserPOS(Set<UserEntity> userPOS) {
        this.userPOS = userPOS;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
