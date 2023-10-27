package com.example.dingdong;

public class Post {
    String adresa,broj,brojtelefona,ime,interfon,korisnik,napomena,naselje,sprat,stan,vreme,vremeprijema;

    public Post(String adresa, String broj, String brojtelefona, String ime, String interfon, String korisnik, String napomena, String naselje, String sprat, String stan, String vreme) {
        this.adresa = adresa;
        this.broj = broj;
        this.brojtelefona = brojtelefona;
        this.ime = ime;
        this.interfon = interfon;
        this.korisnik = korisnik;
        this.napomena = napomena;
        this.naselje = naselje;
        this.sprat = sprat;
        this.stan = stan;
        this.vreme = vreme;
    }

    public Post() {
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public String getBrojtelefona() {
        return brojtelefona;
    }

    public void setBrojtelefona(String brojtelefona) {
        this.brojtelefona = brojtelefona;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getInterfon() {
        return interfon;
    }

    public void setInterfon(String interfon) {
        this.interfon = interfon;
    }

    public String getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getNaselje() {
        return naselje;
    }

    public void setNaselje(String naselje) {
        this.naselje = naselje;
    }

    public String getSprat() {
        return sprat;
    }

    public void setSprat(String sprat) {
        this.sprat = sprat;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }
}
