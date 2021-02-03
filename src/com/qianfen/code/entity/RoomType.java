package com.qianfen.code.entity;

public class RoomType {
    private int id;
    private String name;
    private String picture;
    private String area;
    private String bedWidth;
    private String price;
    private String level;
    private String remark;

    public RoomType() {
    }

    public RoomType(int id, String name, String picture, String area, String bedWidth, String price, String level, String remark) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.area = area;
        this.bedWidth = bedWidth;
        this.price = price;
        this.level = level;
        this.remark = remark;
    }

    public RoomType(String name, String picture, String area, String bedWidth, String price, String level, String remark) {
        this.name = name;
        this.picture = picture;
        this.area = area;
        this.bedWidth = bedWidth;
        this.price = price;
        this.level = level;
        this.remark = remark;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBedWidth() {
        return bedWidth;
    }

    public void setBedWidth(String bedWidth) {
        this.bedWidth = bedWidth;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", area='" + area + '\'' +
                ", bedWidth='" + bedWidth + '\'' +
                ", price='" + price + '\'' +
                ", level='" + level + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
