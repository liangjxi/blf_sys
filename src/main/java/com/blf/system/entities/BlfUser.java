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
@Table(name = "BLF_USER", schema = "BLF_SYS", catalog = "")
public class BlfUser {
    private int id;
    private String code;
    private String loginName;
    private String realName;
    private String pwd;
    private String mobile;
    private String eMail;
    private String createBy;
    private Timestamp createDate;
    private String lastUpdateBy;
    private Timestamp lastUpdateDate;
    private Boolean state;
    private Boolean isDelete;
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
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "LOGIN_NAME")
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Basic
    @Column(name = "REAL_NAME")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "PWD")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "MOBILE")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "E-MAIL")
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
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

        BlfUser blfUser = (BlfUser) o;

        if (id != blfUser.id) return false;
        if (state != blfUser.state) return false;
        if (isDelete != blfUser.isDelete) return false;
        if (code != null ? !code.equals(blfUser.code) : blfUser.code != null) return false;
        if (loginName != null ? !loginName.equals(blfUser.loginName) : blfUser.loginName != null) return false;
        if (realName != null ? !realName.equals(blfUser.realName) : blfUser.realName != null) return false;
        if (pwd != null ? !pwd.equals(blfUser.pwd) : blfUser.pwd != null) return false;
        if (mobile != null ? !mobile.equals(blfUser.mobile) : blfUser.mobile != null) return false;
        if (eMail != null ? !eMail.equals(blfUser.eMail) : blfUser.eMail != null) return false;
        if (createBy != null ? !createBy.equals(blfUser.createBy) : blfUser.createBy != null) return false;
        if (createDate != null ? !createDate.equals(blfUser.createDate) : blfUser.createDate != null) return false;
        if (lastUpdateBy != null ? !lastUpdateBy.equals(blfUser.lastUpdateBy) : blfUser.lastUpdateBy != null)
            return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(blfUser.lastUpdateDate) : blfUser.lastUpdateDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (loginName != null ? loginName.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (lastUpdateBy != null ? lastUpdateBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "blfUserByUserId")
    public Collection<BlfUserPosition> getBlfUserPositionsById() {
        return blfUserPositionsById;
    }

    public void setBlfUserPositionsById(Collection<BlfUserPosition> blfUserPositionsById) {
        this.blfUserPositionsById = blfUserPositionsById;
    }
}
