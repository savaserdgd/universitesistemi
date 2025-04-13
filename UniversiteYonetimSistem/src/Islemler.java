// Islemler.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Islemler {
    private List<Ogrenci> ogrenciler;
    private List<Ogretmen> ogretmenler;
    private List<Ders> dersler;
    private Scanner giris;
    public List<Ogrenci> getOgrenciler() {
        return ogrenciler;
    }
    public List<Ogretmen> getOgretmenler() {
        return ogretmenler;
    }

    public List<Ders> getDersler() {
        return dersler;
    }


    public Islemler() {
        ogrenciler = new ArrayList<>();
        ogretmenler = new ArrayList<>();
        dersler = new ArrayList<>();
        giris = new Scanner(System.in);
    }

    public void ogrenciEkle() {
        System.out.print("Ad: ");
        String ad = giris.nextLine();
        System.out.print("Soyad: ");
        String soyad = giris.nextLine();
        System.out.print("TC Kimlik No: ");
        String tc = giris.nextLine();
        System.out.print("Öğrenci No: ");
        String no = giris.nextLine();

        Ogrenci ogrenci = new Ogrenci(ad, soyad, tc, no);
        ogrenciler.add(ogrenci);
        System.out.println("Öğrenci eklendi!");
    }

    public void ogretmenEkle() {
        System.out.print("Ad: ");
        String ad = giris.nextLine();
        System.out.print("Soyad: ");
        String soyad = giris.nextLine();
        System.out.print("TC Kimlik No: ");
        String tc = giris.nextLine();
        System.out.print("Sicil No: ");
        String sicil = giris.nextLine();

        Ogretmen ogretmen = new Ogretmen(ad, soyad, tc, sicil);
        ogretmenler.add(ogretmen);
        System.out.println("Öğretmen eklendi!");
    }

    public void dersEkle() {
        System.out.print("Ders Kodu: ");
        String kod = giris.nextLine();
        System.out.print("Ders Adı: ");
        String ad = giris.nextLine();

        Ders ders = new Ders(kod, ad);
        dersler.add(ders);
        System.out.println("Ders eklendi!");
    }

    public void tumOgrencileriListele() {
        for (Ogrenci o : ogrenciler) {
            o.bilgileriGoster();
        }
    }

    public void tumOgretmenleriListele() {
        for (Ogretmen o : ogretmenler) {
            o.bilgileriGoster();
        }
    }

    public void tumDersleriListele() {
        for (Ders d : dersler) {
            d.dersBilgisiGoster();
        }
    }

    public void dersAtaOgrenciye() {
        tumOgrencileriListele();
        System.out.print("Ders atanacak öğrenci numarası: ");
        String no = giris.nextLine();
        Ogrenci hedef = null;
        for (Ogrenci o : ogrenciler) {
            if (o.getOgrenciNo().equals(no)) {
                hedef = o;
                break;
            }
        }

        if (hedef == null) {
            System.out.println("Öğrenci bulunamadı!");
            return;
        }

        tumDersleriListele();
        System.out.print("Eklenmek istenen ders kodu: ");
        String kod = giris.nextLine();

        for (Ders d : dersler) {
            if (d.getDersKodu().equals(kod)) {
                hedef.dersEkle(d);
                System.out.println("Ders öğrenciye eklendi.");
                return;
            }
        }
        System.out.println("Ders bulunamadı.");
    }

    public void dersAtaOgretmene() {
        tumOgretmenleriListele();
        System.out.print("Ders atanacak öğretmen sicil no: ");
        String sicil = giris.nextLine();
        Ogretmen hedef = null;
        for (Ogretmen o : ogretmenler) {
            if (o.getSicilNo().equals(sicil)) {
                hedef = o;
                break;
            }
        }

        if (hedef == null) {
            System.out.println("Öğretmen bulunamadı!");
            return;
        }

        tumDersleriListele();
        System.out.print("Eklenmek istenen ders kodu: ");
        String kod = giris.nextLine();

        for (Ders d : dersler) {
            if (d.getDersKodu().equals(kod)) {
                hedef.dersEkle(d);
                System.out.println("Ders öğretmene atandı.");
                return;
            }
        }
        System.out.println("Ders bulunamadı.");
    }
}