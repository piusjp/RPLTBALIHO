/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BalihoBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.sql.DATE;

/**
 *
 * @author HP
 */
public class DBtransaksi {
    private int no_bayar,total_bayar;
    private String kodeSewa;
    private DATE tanggal_bayar;
    
    Connection conn;

    public DBtransaksi() {
        Datahandler dataHandler = new Datahandler();
        dataHandler.getDBConnection();
        conn = dataHandler.conn;
    }

    public int getNo_bayar() {
        return no_bayar;
    }

    public void setNo_bayar(int no_bayar) {
        this.no_bayar = no_bayar;
    }

    public int getTotal_bayar() {
        return total_bayar;
    }

    public void setTotal_bayar(int total_bayar) {
        this.total_bayar = total_bayar;
    }

    public String getKodeSewa() {
        return kodeSewa;
    }

    public void setKodeSewa(String kodeSewa) {
        this.kodeSewa = kodeSewa;
    }

    public DATE getTanggal_bayar() {
        return tanggal_bayar;
    }

    public void setTanggal_bayar(DATE tanggal_bayar) {
        this.tanggal_bayar = tanggal_bayar;
    }
    
    public Integer CekNobar(String nobar) throws SQLException {
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "select count(*) AS jumlah from data_transaksi where no_pembayaran='"+nobar+"'";
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
        String query = "select * from data_transaksi where no_pembayaran = " + keyword ;

        ResultSet rset = stmt.executeQuery(query);
        String seacrh = "";
        while (rset.next()) {
            seacrh = rset.getString(searchData);
        }
        return seacrh;
    }
}
