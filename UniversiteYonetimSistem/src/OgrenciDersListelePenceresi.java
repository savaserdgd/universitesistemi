import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class OgrenciDersListelePenceresi extends JFrame {
    public OgrenciDersListelePenceresi(Islemler islemler) {
        setTitle("Öğrencilerin Aldığı Dersler");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] kolonlar = {"Ad", "Soyad", "Öğrenci No", "Aldığı Dersler"};
        DefaultTableModel model = new DefaultTableModel(kolonlar, 0);

        List<Ogrenci> ogrenciler = islemler.getOgrenciler();
        for (Ogrenci o : ogrenciler) {
            StringBuilder dersler = new StringBuilder();
            for (Ders d : o.getAldigiDersler()) {
                dersler.append(d.getDersAdi()).append(" (").append(d.getDersKodu()).append("), ");
            }
            if (dersler.length() > 0) {
                dersler.setLength(dersler.length() - 2); // Son ", " silinir
            }
            Object[] row = {o.getAd(), o.getSoyad(), o.getOgrenciNo(), dersler.toString()};
            model.addRow(row);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
}
