// KisiBilgileri.java
public abstract class KisiBilgileri {
    private String ad;
    private String soyad;
    private String tcKimlikNo;

    public KisiBilgileri(String ad, String soyad, String tcKimlikNo) {
        this.ad = ad;
        this.soyad = soyad;
        this.tcKimlikNo = tcKimlikNo;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTcKimlikNo() {
        return tcKimlikNo;
    }

    public void setTcKimlikNo(String tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }

    public abstract void bilgileriGoster();
}