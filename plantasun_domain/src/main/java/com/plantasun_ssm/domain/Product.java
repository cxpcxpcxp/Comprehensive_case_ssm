package com.plantasun_ssm.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product implements Serializable {
    private String id;
    private String productNum;
    private String productName;
    private String cityName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date DepartureTime;
    private String DepartureTimeStr;
    private Double productPrice;
    private String productDesc;
    private Integer productStatus;
    private String productStatusStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(Date departureTime) {
        DepartureTime = departureTime;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getDepartureTimeStr() {
        if(DepartureTime!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DepartureTimeStr = sdf.format(DepartureTime);
        }
        return DepartureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        DepartureTimeStr = departureTimeStr;
    }

    public String getProductStatusStr() {
        if(productStatus==0){
            productStatusStr="未开启";
        }else{
            productStatusStr="已开启";
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", DepartureTime=" + DepartureTime +
                ", DepartureTimeStr='" + DepartureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }
}
