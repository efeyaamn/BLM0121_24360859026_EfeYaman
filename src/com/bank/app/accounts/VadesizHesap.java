package com.bank.app.accounts;

public class VadesizHesap extends BankaHesabi {
    private String hesapTuru;

    //constructor
    public VadesizHesap(double bakiye) {
        super(bakiye);//constructora bakiyeyi tanımlıyoruz
        this.hesapTuru = "Vadesiz Hesap";
    }

    //get,set metodlarını yazıyoruyz
    public String getHesapTuru() { return hesapTuru; }
    public void setHesapTuru(String hesapTuru) { this.hesapTuru = hesapTuru; }

    //para gönderme işlerini yapıyoruz
    public void paraTransferi(BankaHesabi aliciHesap, BankaHesabi gonderenHesap, double miktar) {
        //bakiye yeterli mi değil mi kontrol ediyoruz
        if (gonderenHesap.getBakiye() >= miktar) {
            //gönderenin bakiyesi eksiliyor
            gonderenHesap.setBakiye(gonderenHesap.getBakiye() - miktar);
            //alıcının bakiyesi artıyor
            aliciHesap.setBakiye(aliciHesap.getBakiye() + miktar);
            System.out.println("Transfer başarılı. Gönderilen miktar: " + miktar + " TL");
        } else {
            System.out.println("Transfer başarısız! Yetersiz bakiye.");
        }
    }
    public void krediKartiBorcOdeme(com.bank.app.cards.KrediKarti kart, double miktar) {
        if(this.getBakiye() >= miktar) {
            this.setBakiye(this.getBakiye() - miktar); //hesabın bakiyesi azalıyor
            kart.setGuncelBorc(kart.getGuncelBorc() - miktar); //kart borcu azalıyor
            System.out.println("Kredi kartı borcu ödendi. Ödenen: " + miktar + " TL");
        } 
        else{
            System.out.println("Ödeme başarısız! Hesabınızda yeterli bakiye yok.");
        }
    }
    public String toString() {
        return hesapTuru + " | " + super.toString();
    }

	}
