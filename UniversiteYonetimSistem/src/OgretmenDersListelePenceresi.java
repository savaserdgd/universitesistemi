import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class OgretmenDersListelePenceresi extends JFrame {
    public OgretmenDersListelePenceresi(Islemler islemler) {
        setTitle("Öğretmenlerin Verdiği Dersler");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] kolonlar = {"Ad", "Soyad", "Sicil No", "Verdiği Dersler"};
        DefaultTableModel model = new DefaultTableModel(kolonlar, 0);

        List<Ogretmen> ogretmenler = islemler.getOgretmenler();
        for (Ogretmen o : ogretmenler) {
            StringBuilder dersler = new StringBuilder();
            for (Ders d : o.getVerdigiDersler()) {
                dersler.append(d.getDersAdi()).append(" (").append(d.getDersKodu()).append("), ");
            }
            if (dersler.length() > 0) {
                dersler.setLength(dersler.length() - 2);
            }
            Object[] row = {o.getAd(), o.getSoyad(), o.getSicilNo(), dersler.toString()};
            model.addRow(row);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }


}
