//#!$@%$%(^^
package BalihoBean;
//#!$@%$%(^^
import java.sql.*;
import javax.swing.JOptionPane;
import oracle.jdbc.pool.OracleDataSource;

public class Datahandler {
    String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    String userid = "hr";
    String password = "hr";
    Connection conn;

    public Datahandler() {
    }

    public void getDBConnection() {
        try {
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn = ds.getConnection(userid, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Koneksi");
        }
    }
    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Tidak bisa tutup koneksi");
        }
    }
}