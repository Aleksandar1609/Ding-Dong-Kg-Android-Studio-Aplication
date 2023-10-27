package com.example.dingdong;

public class LokacijaPost {
    String longitude,langitude,pocetnakilometraza;
    String email,date,time;

    public LokacijaPost(String longitude, String langitude, String email, String date, String time,String pocetnakilometraza) {
        this.longitude = longitude;
        this.langitude = langitude;
        this.email = email;
        this.date = date;
        this.time = time;
        this.pocetnakilometraza=pocetnakilometraza;
    }


    public String getPocetnakilometraza() {
        return pocetnakilometraza;
    }

    public void setPocetnakilometraza(String pocetnakilometraza) {
        this.pocetnakilometraza = pocetnakilometraza;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLangitude() {
        return langitude;
    }

    public void setLangitude(String langitude) {
        this.langitude = langitude;
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

