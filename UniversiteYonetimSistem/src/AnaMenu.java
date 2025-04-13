import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AnaMenu extends JFrame {
    private Islemler islemler;

    public AnaMenu(Islemler islemler) {
        this.islemler = islemler;

        setTitle("Üniversite Yönetim Sistemi");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1, 10, 10));

        JButton ogrenciEkleBtn = new JButton("Öğrenci Ekle");
        JButton ogretmenEkleBtn = new JButton("Öğretmen Ekle");
        JButton dersEkleBtn = new JButton("Ders Ekle");
        JButton ogrenciListeleBtn = new JButton("Öğrencileri Listele");
        JButton ogretmenListeleBtn = new JButton("Öğretmenleri Listele");
        JButton dersListeleBtn = new JButton("Dersleri Listele");
        JButton ogrenciDersAtaBtn = new JButton("Öğrenciye Ders Ata");
        JButton ogretmenDersAtaBtn = new JButton("Öğretmene Ders Ata");
        JButton ogrenciDersListeleBtn = new JButton("Öğrenci Dersleri Listele");
        JButton ogretmenDersListeleBtn = new JButton("Öğretmen Dersleri Listele");

        panel.add(ogrenciEkleBtn);
        panel.add(ogretmenEkleBtn);
        panel.add(dersEkleBtn);
        panel.add(ogrenciListeleBtn);
        panel.add(ogretmenListeleBtn);
        panel.add(dersListeleBtn);
        panel.add(ogrenciDersAtaBtn);
        panel.add(ogretmenDersAtaBtn);
        panel.add(ogrenciDersListeleBtn);
        panel.add(ogrenciDersListeleBtn);
        add(panel);

        ogrenciEkleBtn.addActionListener(e -> new OgrenciEklePenceresi());
        ogretmenEkleBtn.addActionListener(e -> new OgretmenEklePenceresi());
        dersEkleBtn.addActionListener(e -> new DersEklePenceresi());
        ogrenciDersListeleBtn.addActionListener(e -> new OgrenciDersListelePenceresi(islemler));


        ogrenciListeleBtn.addActionListener(e -> {
            new OgrenciListelePenceresi().setVisible(true);
        });

        ogretmenListeleBtn.addActionListener(e -> {
            new OgretmenListelePenceresi().setVisible(true);
        });

        dersListeleBtn.addActionListener(e -> {
            new DersListelePenceresi().setVisible(true);
        });

        ogrenciDersAtaBtn.addActionListener(e -> new OgrenciDersAtaPenceresi());
        ogretmenDersAtaBtn.addActionListener(e -> new OgretmenDersAtaPenceresi(islemler));
    }

    // main artık giriş ekranına taşındı
}
