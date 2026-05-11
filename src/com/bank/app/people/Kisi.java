package com.bank.app.people;

public class Kisi {
	//sınıf özelliklerini yazıyorz
    private String ad;
    private String soyad;
    private String email;
    private int telefonNumarasi;

    //constructor
    public Kisi(String ad, String soyad, String email, int telefonNumarasi) {
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.telefonNumarasi = telefonNumarasi;
    }

    //get,set metodlarını yazıyoruz
    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }

    public String getSoyad() { return soyad; }
    public void setSoyad(String soyad) { this.soyad = soyad; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getTelefonNumarasi() { return telefonNumarasi; }
    public void setTelefonNumarasi(int telefonNumarasi) { this.telefonNumarasi = telefonNumarasi; }

    //Kisi'nin bilgilerini toString metodu ile metin olarak yazıyoruz
    public String toString() {
        return "Ad: " + ad + ", Soyad: " + soyad + ", Email: " + email + ", Tel: " + telefonNumarasi;
    }

}
