import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class OgrenciDersAtaPenceresi extends JFrame {
    private JComboBox<String> ogrenciCombo, dersCombo;

    public OgrenciDersAtaPenceresi() {
        setTitle("Öğrenciye Ders Ata");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        ogrenciCombo = new JComboBox<>();
        dersCombo = new JComboBox<>();

        // Veritabanından öğrencileri yükle
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universite_db", "root", "581934");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ogrenci")) {

            while (rs.next()) {
                ogrenciCombo.addItem(rs.getString("ogrenci_no") + " - " + rs.getString("ad") + " " + rs.getString("soyad"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Öğrenciler yüklenemedi: " + ex.getMessage());
        }

        // Veritabanından dersleri yükle
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universite_db", "root", "581934");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ders")) {

            while (rs.next()) {
                dersCombo.addItem(rs.getString("ders_kodu") + " - " + rs.getString("ders_adi"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Dersler yüklenemedi: " + ex.getMessage());
        }

        JButton ataBtn = new JButton("Dersi Ata");
        ataBtn.addActionListener(e -> dersiAta());

        add(new JLabel("Öğrenci Seç:"));
        add(ogrenciCombo);
        add(new JLabel("Ders Seç:"));
        add(dersCombo);
        add(new JLabel(""));
        add(ataBtn);

        setVisible(true);
    }

    private void dersiAta() {
        if (ogrenciCombo.getSelectedItem() == null || dersCombo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Lütfen bir öğrenci ve ders seçin.");
            return;
        }

        String ogrenciNo = ogrenciCombo.getSelectedItem().toString().split(" - ")[0];
        String dersKodu = dersCombo.getSelectedItem().toString().split(" - ")[0];

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universite_db", "root", "581934");
             PreparedStatement ps = conn.prepareStatement("INSERT INTO ogrenci_ders (ogrenci_no, ders_kodu) VALUES (?, ?)")) {

            ps.setString(1, ogrenciNo);
            ps.setString(2, dersKodu);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Ders başarıyla atandı!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Atama başarısız: " + ex.getMessage());
        }
    }
}
