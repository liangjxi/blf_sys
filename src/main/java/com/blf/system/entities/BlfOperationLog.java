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
@Table(name = "BLF_OPERATION_LOG", schema = "BLF_SYS", catalog = "")
public class BlfOperationLog {
    private int id;
    private String operationName;
    private int module;
    private String content;
    private int type;
    private Timestamp createDate;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "OPERATION_NAME")
    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    @Basic
    @Column(name = "MODULE")
    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    @Basic
    @Column(name = "CONTENT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "TYPE")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "CREATE_DATE")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlfOperationLog that = (BlfOperationLog) o;

        if (id != that.id) return false;
        if (module != that.module) return false;
        if (type != that.type) return false;
        if (operationName != null ? !operationName.equals(that.operationName) : that.operationName != null)
            return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (operationName != null ? operationName.hashCode() : 0);
        result = 31 * result + module;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + type;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
