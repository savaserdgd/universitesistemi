// Ogretmen.java
import java.util.ArrayList;
import java.util.List;

public class Ogretmen extends KisiBilgileri {
    private String sicilNo;
    private List<Ders> verdigiDersler;

    public Ogretmen(String ad, String soyad, String tcKimlikNo, String sicilNo) {
        super(ad, soyad, tcKimlikNo);
        this.sicilNo = sicilNo;
        this.verdigiDersler = new ArrayList<>();
    }

    public String getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(String sicilNo) {
        this.sicilNo = sicilNo;
    }

    public List<Ders> getVerdigiDersler() {
        return verdigiDersler;
    }

    public void dersEkle(Ders ders) {
        if (!verdigiDersler.contains(ders)) {
            verdigiDersler.add(ders);
            ders.setOgretmen(this);
        }
    }

    public void dersSil(Ders ders) {
        verdigiDersler.remove(ders);
        if (ders.getOgretmen() == this) {
            ders.setOgretmen(null);
        }
    }

    @Override
    public void bilgileriGoster() {
        System.out.println("\n--- Öğretmen Bilgileri ---");
        System.out.println("Ad: " + getAd());
        System.out.println("Soyad: " + getSoyad());
        System.out.println("TC Kimlik No: " + getTcKimlikNo());
        System.out.println("Sicil No: " + sicilNo);
        System.out.println("Verdiği Dersler:");
        for (Ders d : verdigiDersler) {
            System.out.println("- " + d.getDersAdi());
        }
    }
    @Override
    public String toString() {
        return getAd() + " " + getSoyad() + " - " + sicilNo;
    }

}