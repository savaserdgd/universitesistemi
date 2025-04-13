import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/universite_db";
    private static final String USER = "root"; // kendi kullanıcı adını yaz
    private static final String PASSWORD = "581934"; // kendi şifreni yaz

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
