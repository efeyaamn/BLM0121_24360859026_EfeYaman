package com.bank.app.cards;

import java.util.Random;

public class KrediKarti {
	private String kartNumarasi;
    private double limit;
    private double guncelBorc;
    private double kullanilabilirLimit;

    //constructor
    public KrediKarti(double limit, double guncelBorc) {
        this.limit = limit;
        this.guncelBorc = guncelBorc;
        this.kullanilabilirLimit = limit - guncelBorc; //limit harcanılınca yeni kullanılabilir bakiye hesaplanıyor

        //random metodunu kullanarak kart numarası oluşturuyoruz
        Random rnd = new Random();
        long rastgeleSayi = 100000000000L + (long)(rnd.nextDouble() * 900000000000L);
        this.kartNumarasi = "4543" + rastgeleSayi;
    }

    //get,set metodlarını yazıyoruz
    public String getKartNumarasi() { return kartNumarasi; }
    public void setKartNumarasi(String kartNumarasi) { this.kartNumarasi = kartNumarasi; }

    public double getLimit() { return limit; }
    public void setLimit(double limit) { 
        this.limit = limit; 
        guncelleKullanilabilirLimit();
    }

    public double getGuncelBorc() { return guncelBorc; }
    public void setGuncelBorc(double guncelBorc) { 
        this.guncelBorc = guncelBorc; 
        guncelleKullanilabilirLimit();
    }

    public double getKullanilabilirLimit() { return kullanilabilirLimit; }
    private void guncelleKullanilabilirLimit() {
        this.kullanilabilirLimit = this.limit - this.guncelBorc;
    }
    public String toString() {
        return "Kart No: " + kartNumarasi + " | Limit: " + limit + " TL | Güncel Borç: " + guncelBorc + " TL | Kullanılabilir: " + kullanilabilirLimit + " TL";
    }
}
