package com.github.platform.back.domain.po;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Entity
@Table(name = "t_user")
public class UserPO extends BasePO {
    private static final long serialVersionUID = 891593461019475211L;

    private String userName;
    private String password;
    private String salt;
    private String nickName;
    private String phone;
    private String email;

    @JoinTable(name = "t_user_role",
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    @ManyToMany
    private Set<RolePO> rolePOS = new HashSet<>();

    public Set<RolePO> getRolePOS() {
        return rolePOS;
    }

    public void setRolePOS(Set<RolePO> rolePOS) {
        this.rolePOS = rolePOS;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
