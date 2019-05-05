package com.smartcity.domain;

import java.sql.Date;

public class User {

    private Long id;
    private String email;
    private String password;
    private String surname;
    private String name;
    private String phoneNumber;
    private Date createdDate;
    private Date updatedDate;

    public User() {
    }

    public User(Long id, String email, String password, String surname, String name, String phoneNumber, Date createdDate, Date updatedDate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User){
            User user = (User) obj;

            return this.getName().equals(user.getName()) &&
                    this.getSurname().equals(user.getSurname()) &&
                    this.getEmail().equals(user.getEmail()) &&
                    this.getPhoneNumber().equals(user.getPhoneNumber());

        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
