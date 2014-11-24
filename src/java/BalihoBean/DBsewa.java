/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BalihoBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DBsewa {
    private String kode_sewa, kode_baliho,
            nama_customer, alamat_customer, namaPerusahaan, alamatPerusahaan,
            tanggal_mulai, tanggal_berakhir, no_telp, email;
    Connection conn;
    
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
    
    public void tambahDataSewaPrepared(DBsewa dataSewa) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn.setAutoCommit(false);
            String sql = "insert into data_penyewaan(kode_sewa,kode_baliho,nama_customer,alamat_customer,"
                    + "nama_perusahaan,alamat_perusahaan,tanggal_mulai,tanggal_berakhir,no_telepon,email)"
                    + "values (?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dataSewa.getKode_sewa());
            pstmt.setString(2, dataSewa.getKode_baliho());
            pstmt.setString(3, dataSewa.getNama_customer());
            pstmt.setString(4, dataSewa.getAlamat_customer());
            pstmt.setString(5, dataSewa.getNamaPerusahaan());
            pstmt.setString(6, dataSewa.getAlamatPerusahaan());
            pstmt.setString(7, dataSewa.getTanggal_mulai());
            pstmt.setString(8, dataSewa.getTanggal_berakhir());
            pstmt.setString(9, dataSewa.getNo_telp());
            pstmt.setString(10, dataSewa.getEmail());
            pstmt.executeUpdate();
            DBbaliho db=new DBbaliho();
            conn.commit();
            db.updateDipesan(dataSewa.getKode_baliho());
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
}
