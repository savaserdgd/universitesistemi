import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GirisEkrani extends JFrame {
    private JTextField kullaniciAdiAlani;
    private JPasswordField sifreAlani;

    public GirisEkrani(Islemler islemler) {
        setTitle("Giriş Ekranı");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 5, 5));

        JLabel kullaniciAdiEtiketi = new JLabel("Kullanıcı Adı:");
        kullaniciAdiAlani = new JTextField();

        JLabel sifreEtiketi = new JLabel("Şifre:");
        sifreAlani = new JPasswordField();

        JButton girisButonu = new JButton("Giriş Yap");

        girisButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String kullaniciAdi = kullaniciAdiAlani.getText();
                String sifre = new String(sifreAlani.getPassword());

                if (kullaniciAdi.equals("admin123") && sifre.equals("18831883")) {
                    JOptionPane.showMessageDialog(null, "Giriş başarılı!");
                    dispose(); // Giriş ekranını kapat
                    new AnaMenu(islemler).setVisible(true); // Ana menüye geç
                } else {
                    JOptionPane.showMessageDialog(null, "Kullanıcı adı veya şifre hatalı!", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(kullaniciAdiEtiketi);
        add(kullaniciAdiAlani);
        add(sifreEtiketi);
        add(sifreAlani);
        add(girisButonu);
    }
}
