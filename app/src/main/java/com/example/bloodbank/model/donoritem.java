package com.example.bloodbank.model;

public class donoritem {
    private String name,city,bloodGroup,phone;

    public donoritem(){

    }

    public donoritem(String name, String city, String bloodGroup, String phone) {
        this.name = name;
        this.city = city;
        this.bloodGroup = bloodGroup;
        this.phone = phone;
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

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String number) {
        this.phone = number;
    }
}
