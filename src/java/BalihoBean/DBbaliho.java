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


    public void tambahDataBalihoPrepared(DBbaliho dataBaliho) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn.setAutoCommit(false);
            String sql = "insert into data_baliho(kode_baliho,lokasi,harga_sewa,status,ukuran)"
                    + "values (?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dataBaliho.getKodeBaliho());
            pstmt.setString(2, dataBaliho.getLokasi());
            pstmt.setInt(3, dataBaliho.getHargaSewa());
            pstmt.setString(4, dataBaliho.getStatus());
            pstmt.setString(5, dataBaliho.getUkuran());
            pstmt.executeUpdate();
            conn.commit();
            System.out.println("Tambah Data Baliho Berhasil");
        } catch (SQLException exception) {
            conn.rollback();
            System.out.println("Tambah Data Baliho gagal = " + exception.getMessage());
            throw exception;
        } finally {
            try {
                conn.setAutoCommit(true);
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException exception) {
                throw exception;
            }
        }
    }

    public void HapusDataBaliho(String key) throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            statement = conn.prepareStatement("delete from data_baliho where kode_baliho = '" + key + "'");
            result = statement.executeQuery();
            conn.commit();
            System.out.println("Hapus Berhasil");
        } catch (SQLException exception) {
            conn.rollback();
            System.out.println("Hapus gagal :" + exception.getMessage());
            throw exception;
        }
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
    
    public Integer hitungDataBaliho() throws SQLException {
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "select count(*) AS jumlah from data_baliho";
        int jumlahBaliho = 0;
        try {
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                jumlahBaliho = rset.getInt("jumlah");
            }
        } catch (SQLException ex) {
            System.out.println("Gagal hitung jumlah baliho = " + ex.getMessage());
        }
        conn.commit();
        return jumlahBaliho;
    }

    public void UpdateDataBaliho(DBbaliho dataBaliho, String key) throws SQLException {
        PreparedStatement statement = null;
        try {
            conn.setAutoCommit(false);
            String sql = "update data_baliho set kode_baliho=?, lokasi=?, harga_sewa=?, "+
                    "status=?, ukuran=? where kode_baliho=?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, dataBaliho.getKodeBaliho());
            statement.setString(2, dataBaliho.getLokasi());
            statement.setInt(3, dataBaliho.getHargaSewa());
            statement.setString(4, dataBaliho.getStatus());
            statement.setString(5, dataBaliho.getUkuran());
            statement.setString(6, key);
            statement.executeUpdate();
            conn.commit();
            System.out.println("Update Data Baliho Berhasil");
        } catch (SQLException ex) {
            conn.rollback();
            System.out.println("Gagal Update : "+ex.getMessage());
        }
    }

    public void UpdateStatusDataBaliho(String status, String kode) throws SQLException {
        PreparedStatement statement = null;
        try {
            conn.setAutoCommit(false);
            String sql = "update data_baliho set status=? where kode_baliho=?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, status);
            statement.setString(2, kode);
            statement.executeUpdate();
            conn.commit();
            System.out.println("Update Status Data Baliho Berhasil");
        } catch (SQLException ex) {
            conn.rollback();
            System.out.println("Gagal Update Status : "+ex.getMessage());
        }
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
}
