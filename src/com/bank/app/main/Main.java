package com.bank.app.main;

import com.bank.app.people.BankaPersoneli;
import com.bank.app.people.Musteri;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;
import com.bank.app.service.BankaService;

public class Main {
    public static void main(String[] args) {

        //servis ve personel oluşturuyoruz
        BankaService bankaService = new BankaService();
        BankaPersoneli personel = new BankaPersoneli("Yiğit","Beyaz", "yigitbeyaz@btu.edu.tr",123);
        bankaService.personelEkle(personel);

        //1. müşteri oluşturuyoruz
        System.out.println("\n1. ADIM: MÜŞTERİ OLUŞTURMA");
        Musteri musteri = new Musteri("Efe", "Yaman", "efe.yaman@btu.edu.tr", 456);
        personel.getMusteriler().add(musteri); // Müşteri personelin portföyüne atandı
        System.out.println(musteri.toString() + " sisteme kaydedildi.");

        //2. müşteri adına hesap açıyoruz
        System.out.println("\n2. ADIM: HESAP AÇMA İŞLEMLERİ");
        musteri.hesapEkle("Vadesiz");
        musteri.hesapEkle("Yatırım");
        
        //tür dönüşümü yapıyoruz
        VadesizHesap vadesizHesap = (VadesizHesap) musteri.getHesaplar().get(0);
        YatirimHesabi yatirimHesabi = (YatirimHesabi) musteri.getHesaplar().get(1);

        //3. hesaba para yüklüyoruz
        System.out.println("\n3. ADIM: HESABA PARA YATIRMA");
        vadesizHesap.setBakiye(5000.0); //vadesiz hesaba bakiye tanımlıyoruz
        System.out.println("Vadesiz hesaba 5000.0 TL bakiye tanımlandı.");
        
        yatirimHesabi.paraEkle(2000.0); //paraEkle metodunu kullanıyoruz

        //4. hesaplarımız arasında parra gönderiyoruz
        System.out.println("\n4. ADIM: PARA TRANSFERİ");
        System.out.println("Vadesiz hesaptan Yatırım hesabına 1500 TL gönderiliyor");
        vadesizHesap.paraTransferi(yatirimHesabi, vadesizHesap, 1500.0);

        //5. müşteriye kredi kartı oluşturuluyor
        System.out.println("\n5. ADIM: KREDİ KARTI TANIMLAMA");
        musteri.krediKartiEkle(10000.0); // 10.000 TL limitli kart
        KrediKarti kart = musteri.getKrediKartlari().get(0);
        
        //kart ile harcama yapılıp limit azaltılıyor
        kart.setGuncelBorc(2500.0); 
        System.out.println("Karttan 2500 TL harcama yapıldı. Güncel borç: " + kart.getGuncelBorc() + " TL");

        //müşterinin güncel durumuna bakılıyor
        System.out.println("GÜNCEL MÜŞTERİ DURUMU");
        bankaService.musteriOzetGoruntule(musteri);

        //6. kredi kartının borcu ödeniyor
        System.out.println("6. ADIM: KREDİ KARTI BORCU ÖDEME");
        System.out.println("Vadesiz hesaptan 1000 TL kredi kartı borcu ödeniyor");
        vadesizHesap.krediKartiBorcOdeme(kart, 1000.0);

        //şartlar kontrol edilip hesap ve kart siliniyor
        System.out.println("\n7. ADIM: HESAP VE KART SİLME İŞLEMLERİ");
        
        System.out.println("Kalan borcu olan kartı silme denemesi");
        musteri.krediKartiSil(kart); //borç olduğu için silinemez
        
        System.out.println("\nBorcu tamamen ödeyip kartı silme denemesi");
        vadesizHesap.krediKartiBorcOdeme(kart, 1500.0); //borç ödeniyor
        musteri.krediKartiSil(kart); //artık borç kalmadığı içimn silinebiliyor

        System.out.println("\nİçinde para olan Yatırım hesabını silme denemesi");
        musteri.hesapSil(yatirimHesabi); //hesapta para olduğu için silinemez
        
        System.out.println("\nYatırım hesabındaki tüm parayı çekip silme denemesi:");
        yatirimHesabi.paraCek(yatirimHesabi.getBakiye()); //para hesaptan çekildi
        musteri.hesapSil(yatirimHesabi); //hesapta para kalmadığı için silindi

        System.out.println("***TAMAMLANDI***");
    }
}