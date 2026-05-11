package com.bank.app.people;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;
import java.util.ArrayList;
import java.util.Random;

public class Musteri extends Kisi {
    private String musteriNumarasi;
    //listeleri kullanıyoruz
    private ArrayList<BankaHesabi> hesaplar;
    private ArrayList<KrediKarti> krediKartlari;

    public Musteri(String ad, String soyad, String email, int telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
        //random metodu kullanılarak müşteri numarası oluşturuluyor
        Random rnd = new Random();
        this.musteriNumarasi = "MUS" + (10000 + rnd.nextInt(90000));//MUS+5 basamaklı bir numara
        
        this.hesaplar = new ArrayList<>();
        this.krediKartlari = new ArrayList<>();
    }
    //get,set metodlarını yazıyoruz
    public String getMusteriNumarasi() { return musteriNumarasi; }
    public void setMusteriNumarasi(String musteriNumarasi) { this.musteriNumarasi = musteriNumarasi; }

    public ArrayList<BankaHesabi> getHesaplar() { return hesaplar; }
    public ArrayList<KrediKarti> getKrediKartlari() { return krediKartlari; }

    public void hesapEkle(String hesapTuru) {
        if (hesapTuru.equalsIgnoreCase("Vadesiz")) {
            VadesizHesap yeniHesap = new VadesizHesap(0.0); // Başlangıç bakiyesi 0
            hesaplar.add(yeniHesap);
            System.out.println("Vadesiz hesap başarıyla açıldı. IBAN: " + yeniHesap.getIban());
        } else if (hesapTuru.equalsIgnoreCase("Yatırım")) {
            YatirimHesabi yeniHesap = new YatirimHesabi(0.0);
            hesaplar.add(yeniHesap);
            System.out.println("Yatırım hesabı başarıyla açıldı. IBAN: " + yeniHesap.getIban());
        } else {
            System.out.println("Geçersiz hesap türü! 'Vadesiz' veya 'Yatırım' giriniz.");
        }
    }

    //hesap silmek için kontrol yapılıyor
    public void hesapSil(BankaHesabi hesap) {
        if (hesap.getBakiye() > 0) {
            System.out.println("Lütfen öncelikle bakiyenizi başka bir hesaba aktarınız.");
        } else if (hesap.getBakiye() == 0) {
            hesaplar.remove(hesap);
            System.out.println("Hesap başarıyla silindi: " + hesap.getIban());
        }
    }
    
    //kredi kartı oluşturuluyor
    public void krediKartiEkle(double limit) {
        KrediKarti yeniKart = new KrediKarti(limit, 0.0);
        krediKartlari.add(yeniKart);
        System.out.println("Kredi kartı başarıyla eklendi. Kart No: " + yeniKart.getKartNumarasi());
    }

    //kredi kartı silmek için kotrol yapılıyor
    public void krediKartiSil(KrediKarti kart) {
        if (kart.getGuncelBorc() > 0) {
            System.out.println("Lütfen öncelikle borç ödemesi yapınız.");
        } else if (kart.getGuncelBorc() == 0) {
            krediKartlari.remove(kart);
            System.out.println("Kredi kartı başarıyla iptal edildi: " + kart.getKartNumarasi());
        }
    }
    public String toString() {
        return "Müşteri No: " + musteriNumarasi + ", " + super.toString();
    }
}
