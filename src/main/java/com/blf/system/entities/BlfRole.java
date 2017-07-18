package com.blf.system.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * User: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:blf_sys
 * Package:com.blf.system.entities
 * DateTime: 2017/5/16  17:16
 * Description:手动添加
 */
@Entity
@Table(name = "BLF_ROLE", schema = "BLF_SYS", catalog = "")
public class BlfRole {
    private int id;
    private String roleName;
    private String roleCode;
    private String createBy;
    private Timestamp createDate;
    private String lastUpdateBy;
    private Timestamp lastUpdateDate;
    private Boolean state;
    private Boolean isDelete;
    private Collection<BlfPositionRole> blfPositionRolesById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROLE_NAME")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "ROLE_CODE")
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Basic
    @Column(name = "CREATE_BY")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "CREATE_DATE")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "LAST_UPDATE_BY")
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    @Basic
    @Column(name = "LAST_UPDATE_DATE")
    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Basic
    @Column(name = "STATE")
    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Basic
    @Column(name = "IS_DELETE")
    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlfRole blfRole = (BlfRole) o;

        if (id != blfRole.id) return false;
        if (roleName != null ? !roleName.equals(blfRole.roleName) : blfRole.roleName != null) return false;
        if (roleCode != null ? !roleCode.equals(blfRole.roleCode) : blfRole.roleCode != null) return false;
        if (createBy != null ? !createBy.equals(blfRole.createBy) : blfRole.createBy != null) return false;
        if (createDate != null ? !createDate.equals(blfRole.createDate) : blfRole.createDate != null) return false;
        if (lastUpdateBy != null ? !lastUpdateBy.equals(blfRole.lastUpdateBy) : blfRole.lastUpdateBy != null)
            return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(blfRole.lastUpdateDate) : blfRole.lastUpdateDate != null)
            return false;
        if (state != null ? !state.equals(blfRole.state) : blfRole.state != null) return false;
        if (isDelete != null ? !isDelete.equals(blfRole.isDelete) : blfRole.isDelete != null) return false;
        return blfPositionRolesById != null ? blfPositionRolesById.equals(blfRole.blfPositionRolesById) : blfRole.blfPositionRolesById == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (roleCode != null ? roleCode.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (lastUpdateBy != null ? lastUpdateBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        result = 31 * result + (blfPositionRolesById != null ? blfPositionRolesById.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "blfRoleByRoleId")
    public Collection<BlfPositionRole> getBlfPositionRolesById() {
        return blfPositionRolesById;
    }

    public void setBlfPositionRolesById(Collection<BlfPositionRole> blfPositionRolesById) {
        this.blfPositionRolesById = blfPositionRolesById;
    }
}
