package com.qianfen.code.entity;


public class Message {
    private int id;
    private int userId;
    private String userName;
    private String value;
    private String date;

    public Message() {
    }

    public Message(int userId, String value) {
        this.userId = userId;
        this.value = value;
    }

    public Message(int id, int userId, String userName, String value, String date) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.value = value;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", value='" + value + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
