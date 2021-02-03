package com.qianfen.code.entity;

public class Order {
    private int id;
    private int userId;
    private String name;
    private String roomType;
    private String startTime;
    private String endTime;
    private String orderTime;
    private String amount;
    private String remark;
    private boolean status;
    private boolean flag;

    public Order() {
    }

    public Order(int id, int userId, String name, String roomType, String startTime, String endTime, String orderTime, String amount, String remark, boolean status, boolean flag) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.roomType = roomType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.orderTime = orderTime;
        this.amount = amount;
        this.remark = remark;
        this.status = status;
        this.flag = flag;
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

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", roomType='" + roomType + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", amount='" + amount + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", flag=" + flag +
                '}';
    }
}
