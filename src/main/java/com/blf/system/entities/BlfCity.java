package com.blf.system.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * User: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:blf_sys
 * Package:com.blf.system.entities
 * DateTime: 2017/5/16  16:54
 * Description:手动添加
 */
@Entity
@Table(name = "BLF_CITY", schema = "BLF_SYS", catalog = "")
public class BlfCity {
    private int id;
    private String name;
    private String code;
    private String createBy;
    private Timestamp createDate;
    private String lastUpdateBy;
    private Timestamp lastUpdateDate;
    private Boolean state;
    private Boolean isDelete;
    private Collection<BlfProvinceCity> blfProvinceCitiesById;

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
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

        BlfCity blfCity = (BlfCity) o;

        if (id != blfCity.id) return false;
        if (name != null ? !name.equals(blfCity.name) : blfCity.name != null) return false;
        if (code != null ? !code.equals(blfCity.code) : blfCity.code != null) return false;
        if (createBy != null ? !createBy.equals(blfCity.createBy) : blfCity.createBy != null) return false;
        if (createDate != null ? !createDate.equals(blfCity.createDate) : blfCity.createDate != null) return false;
        if (lastUpdateBy != null ? !lastUpdateBy.equals(blfCity.lastUpdateBy) : blfCity.lastUpdateBy != null)
            return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(blfCity.lastUpdateDate) : blfCity.lastUpdateDate != null)
            return false;
        if (state != null ? !state.equals(blfCity.state) : blfCity.state != null) return false;
        if (isDelete != null ? !isDelete.equals(blfCity.isDelete) : blfCity.isDelete != null) return false;
        return blfProvinceCitiesById != null ? blfProvinceCitiesById.equals(blfCity.blfProvinceCitiesById) : blfCity.blfProvinceCitiesById == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (lastUpdateBy != null ? lastUpdateBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        result = 31 * result + (blfProvinceCitiesById != null ? blfProvinceCitiesById.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "blfCityByCityId")
    public Collection<BlfProvinceCity> getBlfProvinceCitiesById() {
        return blfProvinceCitiesById;
    }

    public void setBlfProvinceCitiesById(Collection<BlfProvinceCity> blfProvinceCitiesById) {
        this.blfProvinceCitiesById = blfProvinceCitiesById;
    }
}
