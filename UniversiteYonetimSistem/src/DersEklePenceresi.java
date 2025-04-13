import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class DersEklePenceresi extends JFrame {

    public DersEklePenceresi() {
        setTitle("Ders Ekle");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        JTextField kodField = new JTextField();
        JTextField adField = new JTextField();

        panel.add(new JLabel("Ders Kodu:"));
        panel.add(kodField);
        panel.add(new JLabel("Ders Adı:"));
        panel.add(adField);

        JButton ekleBtn = new JButton("Ekle");
        panel.add(new JLabel()); // boşluk
        panel.add(ekleBtn);

        add(panel);

        ekleBtn.addActionListener(e -> {
            String kod = kodField.getText();
            String ad = adField.getText();

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universite_db", "root", "581934");
                 PreparedStatement stmt = conn.prepareStatement("INSERT INTO ders (ders_kodu, ders_adi) VALUES (?, ?)")) {

                stmt.setString(1, kod);
                stmt.setString(2, ad);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Ders başarıyla eklendi!");
                dispose();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Veritabanı hatası: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}
