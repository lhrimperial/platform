package com.github.platform.back.domain.po;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Entity
@Table(name = "t_role")
public class RolePO extends BasePO {
    private static final long serialVersionUID = 7888953088364381562L;

    private String roleCode;
    private String roleName;

    @ManyToMany(mappedBy = "rolePOS")
    private Set<UserPO> userPOS = new HashSet<>();

    @JoinTable(name = "t_role_resource",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "resource_id", referencedColumnName = "id")})
    @ManyToMany
    private Set<ResourcePO> resourcePOS = new HashSet<>();

    public Set<ResourcePO> getResourcePOS() {
        return resourcePOS;
    }

    public void setResourcePOS(Set<ResourcePO> resourcePOS) {
        this.resourcePOS = resourcePOS;
    }

    public Set<UserPO> getUserPOS() {
        return userPOS;
    }

    public void setUserPOS(Set<UserPO> userPOS) {
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
