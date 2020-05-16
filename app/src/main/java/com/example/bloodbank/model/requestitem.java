package com.example.bloodbank.model;

public class requestitem {
    private String name,city,phone,bloodGroup;

    public requestitem(){

    }

    public requestitem(String name, String city, String phone, String bloodGroup) {
        this.name = name;
        this.city = city;
        this.phone = phone;
        this.bloodGroup = bloodGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
