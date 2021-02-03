package com.qianfen.code.entity;

public class User {
    private int id;
    private String name;
    private String password;
    private String phone;
    private String picture;
    private String sign;
    public User() {
    }

    public User(int id, String name, String password, String phone, String picture, String sign) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.picture = picture;
        this.sign = sign;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", picture='" + picture + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
