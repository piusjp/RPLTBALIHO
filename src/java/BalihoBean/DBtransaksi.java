/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BalihoBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author HP
 */
public class DBtransaksi {

    private int total_bayar;
    private String no_bayar;
    private DBsewa kodeSewa;
    private Date tanggal_bayar;

    Connection conn;

    public String getNo_bayar() {
        return no_bayar;
    }

    public void setNo_bayar(String no_bayar) {
        this.no_bayar = no_bayar;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public DBtransaksi() {
        Datahandler dataHandler = new Datahandler();
        dataHandler.getDBConnection();
        conn = dataHandler.conn;
    }

    public int getTotal_bayar() {
        return total_bayar;
    }

    public void setTotal_bayar(int total_bayar) {
        this.total_bayar = total_bayar;
    }

    public DBsewa getKodeSewa() {
        return kodeSewa;
    }

    public void setKodeSewa(DBsewa kodeSewa) {
        this.kodeSewa = kodeSewa;
    }

    public Date getTanggal_bayar() {
        return tanggal_bayar;
    }

    public void setTanggal_bayar(Date tanggal_bayar) {
        this.tanggal_bayar = tanggal_bayar;
    }

    public void tambahDataTransaksiPrepared(DBtransaksi dataTransaksi) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn.setAutoCommit(false);
//            INSERT INTO DATA_TRANSAKSI(NO_PEMBAYARAN, KODE_SEWA, TANGGAL_BAYAR, TOTAL_BAYAR) VALUES (?, ?, ?, ?)
            DBpesan dp = new DBpesan();
            
            String sql = "INSERT INTO DATA_TRANSAKSI(NO_PEMBAYARAN, KODE_SEWA, TANGGAL_BAYAR, TOTAL_BAYAR) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dp.getNo_bayar());
            pstmt.setString(2, dataTransaksi.getKodeSewa().getKode_sewa());
            pstmt.setDate(3, (java.sql.Date) dataTransaksi.getTanggal_bayar());
            pstmt.setInt(4, dataTransaksi.getTotal_bayar());
            pstmt.executeUpdate();
            DBbaliho db = new DBbaliho();
            conn.commit();
//            db.updateDipesan(dataTransaksi.getKode_baliho());
            System.out.println("Konfirmasi Pembayaran berhasil!");
        } catch (SQLException exception) {
            conn.rollback();
            System.out.println("Konfirmasi Pembayaran gagal = " + exception.getMessage());
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

    public Integer CekNobar(String nobar) throws SQLException {
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "select count(*) AS jumlah from data_transaksi where no_pembayaran='" + nobar + "'";
        int jml = 0;
        try {
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                jml = rset.getInt("jumlah");
            }
        } catch (SQLException ex) {
            System.out.println("Gagal hitung jumlah baliho = " + ex.getMessage());
        }
        conn.commit();
        return jml;
    }

    public String search(String keyword, String searchData) throws SQLException, Exception {

        Datahandler dataHandler = new Datahandler();
        dataHandler.getDBConnection();
        Connection conn = dataHandler.conn;
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String query = "select * from data_transaksi where no_pembayaran = " + keyword;

        ResultSet rset = stmt.executeQuery(query);
        String seacrh = "";
        while (rset.next()) {
            seacrh = rset.getString(searchData);
        }
        conn.commit();
        return seacrh;
    }
}
