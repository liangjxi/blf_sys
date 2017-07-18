package com.blf.system.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * User: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:blf_sys
 * Package:com.blf.system.entities
 * DateTime: 2017/5/16  17:16
 * Description:手动添加
 */
@Entity
@Table(name = "BLF_DEPARTMENT_POSITION", schema = "BLF_SYS", catalog = "")
public class BlfDepartmentPosition {
    private int id;
    private String desc;
    private String createBy;
    private Timestamp createDate;
    private String lastUpdateBy;
    private Timestamp lastUpdateDate;
    private Boolean state;
    private Boolean isDelete;
    private BlfPosition blfPositionByPositionId;
    private BlfDepartment blfDepartmentByDepartmentId;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        BlfDepartmentPosition that = (BlfDepartmentPosition) o;

        if (id != that.id) return false;
        if (state != that.state) return false;
        if (isDelete != that.isDelete) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (createBy != null ? !createBy.equals(that.createBy) : that.createBy != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (lastUpdateBy != null ? !lastUpdateBy.equals(that.lastUpdateBy) : that.lastUpdateBy != null) return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(that.lastUpdateDate) : that.lastUpdateDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (lastUpdateBy != null ? lastUpdateBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        result = 31 * result + (blfPositionByPositionId != null ? blfPositionByPositionId.hashCode() : 0);
        result = 31 * result + (blfDepartmentByDepartmentId != null ? blfDepartmentByDepartmentId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "POSITION_ID", referencedColumnName = "ID", nullable = false)
    public BlfPosition getBlfPositionByPositionId() {
        return blfPositionByPositionId;
    }

    public void setBlfPositionByPositionId(BlfPosition blfPositionByPositionId) {
        this.blfPositionByPositionId = blfPositionByPositionId;
    }

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "ID", nullable = false)
    public BlfDepartment getBlfDepartmentByDepartmentId() {
        return blfDepartmentByDepartmentId;
    }

    public void setBlfDepartmentByDepartmentId(BlfDepartment blfDepartmentByDepartmentId) {
        this.blfDepartmentByDepartmentId = blfDepartmentByDepartmentId;
    }
}
