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
@Table(name = "BLF_POSITION", schema = "BLF_SYS", catalog = "")
public class BlfPosition {
    private int id;
    private String name;
    private String desc;
    private String createBy;
    private Timestamp createDate;
    private String lastUpdateBy;
    private Timestamp lastUpdateDate;
    private Boolean state;
    private Boolean isDelete;
    private Collection<BlfDepartmentPosition> blfDepartmentPositionsById;
    private Collection<BlfPositionRole> blfPositionRolesById;
    private Collection<BlfUserPosition> blfUserPositionsById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "DESC")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
    @Column(name = "CREATE-DATE")
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

        BlfPosition that = (BlfPosition) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (createBy != null ? !createBy.equals(that.createBy) : that.createBy != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (lastUpdateBy != null ? !lastUpdateBy.equals(that.lastUpdateBy) : that.lastUpdateBy != null) return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(that.lastUpdateDate) : that.lastUpdateDate != null)
            return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (isDelete != null ? !isDelete.equals(that.isDelete) : that.isDelete != null) return false;
        if (blfDepartmentPositionsById != null ? !blfDepartmentPositionsById.equals(that.blfDepartmentPositionsById) : that.blfDepartmentPositionsById != null)
            return false;
        if (blfPositionRolesById != null ? !blfPositionRolesById.equals(that.blfPositionRolesById) : that.blfPositionRolesById != null)
            return false;
        return blfUserPositionsById != null ? blfUserPositionsById.equals(that.blfUserPositionsById) : that.blfUserPositionsById == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (lastUpdateBy != null ? lastUpdateBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        result = 31 * result + (blfDepartmentPositionsById != null ? blfDepartmentPositionsById.hashCode() : 0);
        result = 31 * result + (blfPositionRolesById != null ? blfPositionRolesById.hashCode() : 0);
        result = 31 * result + (blfUserPositionsById != null ? blfUserPositionsById.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "blfPositionByPositionId")
    public Collection<BlfDepartmentPosition> getBlfDepartmentPositionsById() {
        return blfDepartmentPositionsById;
    }

    public void setBlfDepartmentPositionsById(Collection<BlfDepartmentPosition> blfDepartmentPositionsById) {
        this.blfDepartmentPositionsById = blfDepartmentPositionsById;
    }

    @OneToMany(mappedBy = "blfPositionByPositionId")
    public Collection<BlfPositionRole> getBlfPositionRolesById() {
        return blfPositionRolesById;
    }

    public void setBlfPositionRolesById(Collection<BlfPositionRole> blfPositionRolesById) {
        this.blfPositionRolesById = blfPositionRolesById;
    }

    @OneToMany(mappedBy = "blfPositionByPositionId")
    public Collection<BlfUserPosition> getBlfUserPositionsById() {
        return blfUserPositionsById;
    }

    public void setBlfUserPositionsById(Collection<BlfUserPosition> blfUserPositionsById) {
        this.blfUserPositionsById = blfUserPositionsById;
    }
}
