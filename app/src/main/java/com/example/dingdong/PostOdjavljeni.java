package com.example.dingdong;

public class PostOdjavljeni {
    String email,date,time,kilometraza;

    public PostOdjavljeni(String email, String date, String time,String kilometraza) {
        this.email = email;
        this.date = date;
        this.time = time;
        this.kilometraza=kilometraza;
    }

    public String getKilometraza() {
        return kilometraza;
    }

    public void setKilometraza(String kilometraza) {
        this.kilometraza = kilometraza;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}

