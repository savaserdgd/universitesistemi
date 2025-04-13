import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OgrenciEklePenceresi extends JFrame {

    public OgrenciEklePenceresi() {
        setTitle("Öğrenci Ekle");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));

        JTextField adField = new JTextField();
        JTextField soyadField = new JTextField();
        JTextField tcField = new JTextField();
        JTextField noField = new JTextField();

        panel.add(new JLabel("Ad:"));
        panel.add(adField);
        panel.add(new JLabel("Soyad:"));
        panel.add(soyadField);
        panel.add(new JLabel("TC Kimlik No:"));
        panel.add(tcField);
        panel.add(new JLabel("Öğrenci No:"));
        panel.add(noField);

        JButton ekleBtn = new JButton("Ekle");
        panel.add(ekleBtn);

        add(panel);

        ekleBtn.addActionListener(e -> {
            String ad = adField.getText().trim();
            String soyad = soyadField.getText().trim();
            String tc = tcField.getText().trim();
            String no = noField.getText().trim();

            if (ad.isEmpty() || soyad.isEmpty() || tc.isEmpty() || no.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Lütfen tüm alanları doldurun!");
                return;
            }

            try {
                Connection conn = DBConnection.getConnection();
                String sql = "INSERT INTO ogrenci (ad, soyad, tc_kimlik_no, ogrenci_no) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, ad);
                stmt.setString(2, soyad);
                stmt.setString(3, tc);
                stmt.setString(4, no);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Öğrenci başarıyla eklendi!");
                conn.close();
                dispose(); // pencereyi kapat
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Veritabanı hatası: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}
