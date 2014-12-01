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

/**
 *
 * @author HP
 */
public class DBsewa {

    private String kode_sewa, kode_baliho,
            nama_customer, alamat_customer, namaPerusahaan, alamatPerusahaan,
            tanggal_mulai, tanggal_berakhir, no_telp, email;
    Connection conn;
    DBbaliho db=new DBbaliho();
    DBpesan pesan=new DBpesan();

    public DBsewa() {
        Datahandler dataHandler = new Datahandler();
        dataHandler.getDBConnection();
        conn = dataHandler.conn;
    }

    public String getKode_sewa() {
        return kode_sewa;
    }

    public void setKode_sewa(String kode_sewa) {
        this.kode_sewa = kode_sewa;
    }

    public String getKode_baliho() {
        return kode_baliho;
    }

    public void setKode_baliho(String kode_baliho) {
        this.kode_baliho = kode_baliho;
    }

    public String getNama_customer() {
        return nama_customer;
    }

    public void setNama_customer(String nama_customer) {
        this.nama_customer = nama_customer;
    }

    public String getAlamat_customer() {
        return alamat_customer;
    }

    public void setAlamat_customer(String alamat_customer) {
        this.alamat_customer = alamat_customer;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getAlamatPerusahaan() {
        return alamatPerusahaan;
    }

    public void setAlamatPerusahaan(String alamatPerusahaan) {
        this.alamatPerusahaan = alamatPerusahaan;
    }

    public String getTanggal_mulai() {
        return tanggal_mulai;
    }

    public void setTanggal_mulai(String tanggal_mulai) {
        this.tanggal_mulai = tanggal_mulai;
    }

    public String getTanggal_berakhir() {
        return tanggal_berakhir;
    }

    public void setTanggal_berakhir(String tanggal_berakhir) {
        this.tanggal_berakhir = tanggal_berakhir;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void copyData(String kodePesan,String nobar) throws SQLException {
        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String query = "insert into data_penyewaan (kode_sewa, kode_baliho, nama_customer, alamat_customer, nama_perusahaan, alamat_perusahaan,tanggal_mulai,tanggal_berakhir,no_telp,email)\n"
                    + "select CONCAT(kode_pesan,'"+nobar+"'), kode_baliho, nama_customer, alamat_customer, nama_perusahaan, alamat_perusahaan, tanggal_mulai,ADD_MONTHS(tanggal_mulai,lama_sewa),no_telp,email from data_pemesanan\n"
                    + "where kode_pesan='"+kodePesan+"'";
            stmt.executeQuery(query);
            updateDisewa(kodePesan);
            pesan.HapusDataPesan(kodePesan);
            conn.commit();
        } catch (SQLException exception) {
            conn.rollback();
            System.out.println("Tambah Data Jadwal Pertandingan gagal = " + exception.getMessage());
            throw exception;
        }
    }
    public void updateDisewa(String kodePesan) throws SQLException {
        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String query = "update data_baliho set status='DISEWA' where kode_baliho in (SELECT kode_baliho FROM data_pemesanan where kode_pesan='"+kodePesan+"')";
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
