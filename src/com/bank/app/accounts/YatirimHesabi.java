package com.bank.app.accounts;

public class YatirimHesabi extends BankaHesabi{
	private String hesapTuru;

    //constructor
    public YatirimHesabi(double bakiye) {
        super(bakiye);
        this.hesapTuru = "Yatırım Hesabı";
    }

    //get,set metodlarını yazıyoruz
    public String getHesapTuru(){return hesapTuru;}
    public void setHesapTuru(String hesapTuru){this.hesapTuru = hesapTuru;}

    //yatırım hesabını para yüklüyoruz 
    public void paraEkle(double miktar) {
        if (miktar > 0) {
            this.setBakiye(this.getBakiye() + miktar);
            System.out.println(miktar + " TL yatırım hesabınıza eklendi. Güncel bakiye: " + this.getBakiye() + " TL");
        } 
        else{
            System.out.println("Geçersiz miktar girdiniz.");
        }
    }

    //yatırım hesabından para çekiliyor
    public void paraCek(double miktar) {
        //çekilen bakiye yeterli mi değil mi kontrol ediliyor
        if (this.getBakiye() >= miktar && miktar > 0) {
            this.setBakiye(this.getBakiye() - miktar);
            System.out.println(miktar + " TL yatırım hesabınızdan çekildi. Kalan bakiye: " + this.getBakiye() + " TL");
        } else {
            System.out.println("Para çekme başarısız! Yetersiz bakiye.");
        }
    }
    public String toString() {
        return hesapTuru + " | " + super.toString();
    }
}
