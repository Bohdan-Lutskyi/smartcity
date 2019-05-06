package com.smartcity.domain;

import java.time.LocalDate;
import java.util.Objects;

public class User {

    private Long id;
    private String email;
    private String password;
    private String surname;
    private String name;
    private String phoneNumber;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    public User() {
    }

    public User(Long id, String email, String password, String surname, String name, String phoneNumber, LocalDate createdDate, LocalDate updatedDate) {
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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email) &&
                password.equals(user.password) &&
                surname.equals(user.surname) &&
                name.equals(user.name) &&
                phoneNumber.equals(user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, surname, name, phoneNumber, createdDate, updatedDate);
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
