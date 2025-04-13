import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class DersListelePenceresi extends JFrame {

    public DersListelePenceresi() {
        setTitle("Ders Listesi");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] kolonlar = {"Ders Kodu", "Ders Adı"};
        DefaultTableModel model = new DefaultTableModel(kolonlar, 0);
        JTable table = new JTable(model);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universite_db", "root", "581934");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT ders_kodu, ders_adi FROM ders")) {

            while (rs.next()) {
                String kod = rs.getString("ders_kodu");
                String ad = rs.getString("ders_adi");
                model.addRow(new Object[]{kod, ad});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Veritabanı hatası: " + ex.getMessage());
        }

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
