/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BalihoBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class DBbaliho {

    private String kodeBaliho;
    private String lokasi;
    private int hargaSewa;
    private String status;
    private String ukuran;
    Connection conn;

    public DBbaliho() {
        Datahandler dataHandler = new Datahandler();
        dataHandler.getDBConnection();
        conn = dataHandler.conn;
    }

    public DBbaliho(Connection koneksi) {
        this.conn = koneksi;
    }

    public String getKodeBaliho() {
        return kodeBaliho;
    }

    public void setKodeBaliho(String kodeBaliho) {
        this.kodeBaliho = kodeBaliho;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public int getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(int hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public ResultSet data_baliho() throws SQLException, Exception {
        Datahandler dataHandler = new Datahandler();
        dataHandler.getDBConnection();
        Connection conn = dataHandler.conn;
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String query = "select * from data_baliho";

        ResultSet rset = stmt.executeQuery(query);
        return rset;
    }

    public String search(String keyword, String searchData) throws SQLException, Exception {

        Datahandler dataHandler = new Datahandler();
        dataHandler.getDBConnection();
        Connection conn = dataHandler.conn;
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String query = "select * from data_baliho where KODE_BALIHO='" + keyword + "'";

        ResultSet rset = stmt.executeQuery(query);
        String seacrh = "";
        while (rset.next()) {
            seacrh = rset.getString(searchData);
        }
        return seacrh;
    }
    
    public void updateDipesan(String kode) throws SQLException {
        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String query = "update data_baliho set status='DIPESAN' where kode_baliho='" + kode + "'";
            stmt.executeQuery(query);
            conn.commit();
            System.out.println("Tambah Data Jadwal Berhasil");
        } catch (SQLException exception) {
            conn.rollback();
            System.out.println("Tambah Data Jadwal Pertandingan gagal = " + exception.getMessage());
            throw exception;
        }
    }
}
