import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class OgretmenListelePenceresi extends JFrame {

    public OgretmenListelePenceresi() {
        setTitle("Öğretmen Listesi");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] kolonlar = {"Ad", "Soyad", "TC Kimlik No", "Sicil No"};
        DefaultTableModel model = new DefaultTableModel(kolonlar, 0);
        JTable table = new JTable(model);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universite_db", "root", "581934");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ogretmen")) {

            while (rs.next()) {
                String ad = rs.getString("ad");
                String soyad = rs.getString("soyad");
                String tc = rs.getString("tc");
                String sicil = rs.getString("sicil_no");
                model.addRow(new Object[]{ad, soyad, tc, sicil});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Veritabanı hatası: " + ex.getMessage());
        }

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
