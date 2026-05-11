package com.bank.app.service;

import com.bank.app.people.BankaPersoneli;
import com.bank.app.people.Musteri;
import com.bank.app.accounts.BankaHesabi;
import com.bank.app.cards.KrediKarti;
import java.util.ArrayList;

//service sınıfı personellerin listesini tutuyor

public class BankaService {
    //bankadaki tüm personelleri tutuyor
    private ArrayList<BankaPersoneli> personeller;

    public BankaService() {
        this.personeller = new ArrayList<>();
    }

    //yeni personel ekleme metodu
    public void personelEkle(BankaPersoneli personel) {
        personeller.add(personel);
        System.out.println("Sisteme yeni personel eklendi: " + personel.getAd() + " (ID: " + personel.getPersonelID() + ")");
    }
    public Musteri musteriBul(String musteriNo) {
        for (BankaPersoneli personel : personeller) {
            for (Musteri m : personel.getMusteriler()) {
                if (m.getMusteriNumarasi().equals(musteriNo)) {
                    return m;
                }
            }
        }
        System.out.println("Müşteri bulunamadı: " + musteriNo);
        return null;
    }
    public void musteriOzetGoruntule(Musteri musteri) {
        if (musteri == null) return;

        System.out.println("\nMÜŞTERİ ÖZETİ");
        System.out.println(musteri.toString());
        
        System.out.println("\nBanka Hesapları");
        if (musteri.getHesaplar().isEmpty()) {
            System.out.println("Aktif hesap bulunmamaktadır.");
        } else {
            for (BankaHesabi hesap : musteri.getHesaplar()) {
                System.out.println("- " + hesap.toString());
            }
        }

        System.out.println("\nKredi Kartları");
        if (musteri.getKrediKartlari().isEmpty()) {
            System.out.println("Tanımlı kredi kartı bulunmamaktadır.");
        } else {
            for (KrediKarti kart : musteri.getKrediKartlari()) {
                System.out.println("- " + kart.toString());
            }
        }
    }
    public ArrayList<BankaPersoneli> getPersoneller() {
        return personeller;
    }
}