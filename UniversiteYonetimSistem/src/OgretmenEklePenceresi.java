import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class OgretmenEklePenceresi extends JFrame {

    public OgretmenEklePenceresi() {
        setTitle("Öğretmen Ekle");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JTextField adField = new JTextField();
        JTextField soyadField = new JTextField();
        JTextField tcField = new JTextField();
        JTextField sicilField = new JTextField();

        panel.add(new JLabel("Ad:"));
        panel.add(adField);
        panel.add(new JLabel("Soyad:"));
        panel.add(soyadField);
        panel.add(new JLabel("TC Kimlik No:"));
        panel.add(tcField);
        panel.add(new JLabel("Sicil No:"));
        panel.add(sicilField);

        JButton ekleBtn = new JButton("Ekle");
        panel.add(new JLabel()); // boşluk
        panel.add(ekleBtn);

        add(panel);

        ekleBtn.addActionListener(e -> {
            String ad = adField.getText();
            String soyad = soyadField.getText();
            String tc = tcField.getText();
            String sicilNo = sicilField.getText();

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universite_db", "root", "581934");
                 PreparedStatement stmt = conn.prepareStatement("INSERT INTO ogretmen (ad, soyad, tc, sicil_no) VALUES (?, ?, ?, ?)")) {

                stmt.setString(1, ad);
                stmt.setString(2, soyad);
                stmt.setString(3, tc);
                stmt.setString(4, sicilNo);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Öğretmen başarıyla eklendi!");
                dispose();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Veritabanı hatası: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}
