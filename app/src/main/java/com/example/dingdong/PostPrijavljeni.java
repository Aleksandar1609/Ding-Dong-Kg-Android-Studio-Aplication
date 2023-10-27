package com.example.dingdong;

public class PostPrijavljeni {
    String date,time,email,predjenakilometraza;

    public PostPrijavljeni(String date, String time, String email,String predjenakilometraza) {
        this.date = date;
        this.time = time;
        this.email = email;
        this.predjenakilometraza=predjenakilometraza;
    }

    public String getPredjenakilometraza() {
        return predjenakilometraza;
    }

    public void setPredjenakilometraza(String predjenakilometraza) {
        this.predjenakilometraza = predjenakilometraza;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

