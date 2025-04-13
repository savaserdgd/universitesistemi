// Ogrenci.java
import java.util.ArrayList;
import java.util.List;

public class Ogrenci extends KisiBilgileri {
    private String ogrenciNo;
    private List<Ders> aldigiDersler;

    public Ogrenci(String ad, String soyad, String tcKimlikNo, String ogrenciNo) {
        super(ad, soyad, tcKimlikNo);
        this.ogrenciNo = ogrenciNo;
        this.aldigiDersler = new ArrayList<>();
    }

    public String getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(String ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public List<Ders> getAldigiDersler() {
        return aldigiDersler;
    }

    public void dersEkle(Ders ders) {
        if (!aldigiDersler.contains(ders)) {
            aldigiDersler.add(ders);
            ders.ogrenciEkle(this);
        }
    }

    public void dersSil(Ders ders) {
        aldigiDersler.remove(ders);
        ders.ogrenciCikar(this);
    }

    @Override
    public void bilgileriGoster() {
        System.out.println("\n--- Öğrenci Bilgileri ---");
        System.out.println("Ad: " + getAd());
        System.out.println("Soyad: " + getSoyad());
        System.out.println("TC Kimlik No: " + getTcKimlikNo());
        System.out.println("Öğrenci No: " + ogrenciNo);
        System.out.println("Aldığı Dersler:");
        for (Ders d : aldigiDersler) {
            System.out.println("- " + d.getDersAdi());
        }
    }
    @Override
    public String toString() {
        return getAd() + " " + getSoyad() + " - " + ogrenciNo;
    }

}