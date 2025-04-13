import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Arayüz işlemleri EDT (Event Dispatch Thread) üzerinden başlatılmalı
        SwingUtilities.invokeLater(() -> {
            Islemler islemler = new Islemler();
            new GirisEkrani(islemler).setVisible(true);
        });
    }
}
