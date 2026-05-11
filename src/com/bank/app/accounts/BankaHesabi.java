package com.bank.app.accounts;

import java.util.Random;

public class BankaHesabi {
	private String iban;
    private double bakiye;

    // constructor
    public BankaHesabi(double bakiye) {
        this.bakiye = bakiye;
        
        // random metodunu kullanarak iban oluşturuyoruz 
        Random rnd = new Random();
        long rastgeleSayi = 1000000000L + (long)(rnd.nextDouble() * 9000000000L);//on basamaklı bir iban numarası oluşuyor
        this.iban = "TR" + rastgeleSayi;
    }

    //get,set metodlarını yazıyoruz
    public String getIban() { return iban; }
    public void setIban(String iban) { this.iban = iban; }

    public double getBakiye() { return bakiye; }
    public void setBakiye(double bakiye) { this.bakiye = bakiye; }

    public String toString() {
        return "IBAN: " + iban + " | Bakiye: " + bakiye + " TL";
    }

}
