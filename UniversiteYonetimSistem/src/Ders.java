// Ders.java
import java.util.ArrayList;
import java.util.List;

public class Ders {
    private String dersKodu;
    private String dersAdi;
    private Ogretmen ogretmen;
    private List<Ogrenci> ogrenciler;

    public Ders(String dersKodu, String dersAdi) {
        this.dersKodu = dersKodu;
        this.dersAdi = dersAdi;
        this.ogrenciler = new ArrayList<>();
    }

    public String getDersKodu() {
        return dersKodu;
    }

    public void setDersKodu(String dersKodu) {
        this.dersKodu = dersKodu;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public Ogretmen getOgretmen() {
        return ogretmen;
    }

    public void setOgretmen(Ogretmen ogretmen) {
        this.ogretmen = ogretmen;
    }

    public List<Ogrenci> getOgrenciler() {
        return ogrenciler;
    }

    public void ogrenciEkle(Ogrenci ogrenci) {
        this.ogrenciler.add(ogrenci);
    }

    public void ogrenciCikar(Ogrenci ogrenci) {
        this.ogrenciler.remove(ogrenci);
    }

    public void dersBilgisiGoster() {
        System.out.println("Ders Kodu: " + dersKodu);
        System.out.println("Ders Adı: " + dersAdi);
        System.out.println("Öğretmen: " + (ogretmen != null ? ogretmen.getAd() + " " + ogretmen.getSoyad() : "Atanmadı"));
        System.out.println("Kayıtlı Öğrenciler: ");
        for (Ogrenci o : ogrenciler) {
            System.out.println("- " + o.getAd() + " " + o.getSoyad());
        }
    }
    @Override
    public String toString() {
        return this.dersAdi; // Ders için
    }

}
