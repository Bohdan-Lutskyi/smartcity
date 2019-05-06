package com.smartcity.domain;

import java.sql.Date;

public class Organization {

    private Long id;
    private String name;
    private String address;
    private Date createdDate;
    private Date updatedDate;

    public Organization() {
    }

    public Organization(Long id, String name, String addres, Date createdDate, Date updatedDate) {
        this.id = id;
        this.name = name;
        this.address = addres;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String addres) {
        this.address = addres;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
