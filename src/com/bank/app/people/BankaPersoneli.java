package com.bank.app.people;

import java.util.ArrayList;
import java.util.Random;

public class BankaPersoneli extends Kisi {
	private String personelID;
    private ArrayList<Musteri> musteriler;

    //constructor
    public BankaPersoneli(String ad, String soyad, String email, int telefonNumarasi) {
        //super metodunu kullanarak Kisi'ye bilgiler gönderiliyor
        super(ad, soyad, email, telefonNumarasi);
        
        //random metodunu kullanarak personel ID'si oluşturuyoruz
        Random rnd = new Random();
        this.personelID = "PER" + (1000 + rnd.nextInt(9000)); //PER+4 basamaklı bir numara
        
        //içi boş arraylisti başlatıyoruz
        this.musteriler = new ArrayList<>(); 
    }

    //get,set metodlarını yazıyoruz 
    public String getPersonelID() { return personelID; }
    public void setPersonelID(String personelID) { this.personelID = personelID; }

    public ArrayList<Musteri> getMusteriler() { return musteriler; }
    public void setMusteriler(ArrayList<Musteri> musteriler) { this.musteriler = musteriler; }
    public String toString() {
        return "Personel ID: " + personelID + ", " + super.toString();
    }
}
