package com.smartcity.domain;

import java.sql.Date;

public class Organization {

    private Long id;
    private String name;
    private String addres;
    private Date createDate;
    private Date updateDate;

    public Organization(Long id, String name, String addres, Date createDate, Date updateDate) {
        this.id = id;
        this.name = name;
        this.addres = addres;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
