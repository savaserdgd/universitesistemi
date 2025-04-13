import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class OgretmenDersAtaPenceresi extends JFrame {
    private JComboBox<Ogretmen> ogretmenCombo;
    private JComboBox<Ders> dersCombo;

    public OgretmenDersAtaPenceresi(Islemler islemler) {
        setTitle("Öğretmene Ders Ata");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        ogretmenCombo = new JComboBox<>();
        dersCombo = new JComboBox<>();

        for (Ogretmen o : islemler.getOgretmenler()) {
            ogretmenCombo.addItem(o);
        }

        for (Ders d : islemler.getDersler()) {
            dersCombo.addItem(d);
        }

        JButton ataBtn = new JButton("Dersi Ata");
        ataBtn.addActionListener(e -> dersiAta());

        add(new JLabel("Öğretmen Seç:"));
        add(ogretmenCombo);
        add(new JLabel("Ders Seç:"));
        add(dersCombo);
        add(new JLabel(""));
        add(ataBtn);

        setVisible(true);
    }

    private void dersiAta() {
        if (ogretmenCombo.getSelectedItem() == null || dersCombo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Lütfen bir öğretmen ve ders seçin.");
            return;
        }

        Ogretmen secilenOgretmen = (Ogretmen) ogretmenCombo.getSelectedItem();
        Ders secilenDers = (Ders) dersCombo.getSelectedItem();

        String sicilNo = secilenOgretmen.getSicilNo();
        String dersKodu = secilenDers.getDersKodu();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universite_db", "root", "581934");
             PreparedStatement ps = conn.prepareStatement("INSERT INTO ogretmen_ders (id_ogretmen, id_ders) VALUES (?, ?)")) {

            ps.setString(1, sicilNo);
            ps.setString(2, dersKodu);
            ps.executeUpdate();

            // Bellekte de ilişki kur
            secilenOgretmen.dersEkle(secilenDers);

            JOptionPane.showMessageDialog(this, "Ders başarıyla öğretmene atandı!");
            dispose();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Atama başarısız: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
