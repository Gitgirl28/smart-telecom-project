package com.smarttelecom.backend.model;

import lombok.Data;

@Data
public class Device { //java object
    private Long id;
    private String name;
    private  String brand;
    private double price;
    private String status;
    public Device(){

    }
    public Device(Long id, String name, String brand, double price, String status){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.status = status;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
