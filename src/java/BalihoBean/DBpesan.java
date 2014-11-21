/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BalihoBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author HP
 */
public class DBpesan {
    private String kode_pesan,kode_baliho1,kode_baliho2,kode_baliho3,
            nama_customer,alamat_customer,namaPerusahaan,alamatPerusahaan,
            batas_pembayaran,tanggal_mulai,noHp,email;
    private int lamaSewa;
    Connection conn;

    public DBpesan() {
        Datahandler dataHandler = new Datahandler();
        dataHandler.getDBConnection();
        conn = dataHandler.conn;
    }

    public String getKode_pesan() {
        return kode_pesan;
    }

    public void setKode_pesan(String kode_pesan) {
        this.kode_pesan = kode_pesan;
    }

    public String getKode_baliho1() {
        return kode_baliho1;
    }

    public void setKode_baliho1(String kode_baliho1) {
        this.kode_baliho1 = kode_baliho1;
    }

    public String getKode_baliho2() {
        return kode_baliho2;
    }

    public void setKode_baliho2(String kode_baliho2) {
        this.kode_baliho2 = kode_baliho2;
    }

    public String getKode_baliho3() {
        return kode_baliho3;
    }

    public void setKode_baliho3(String kode_baliho3) {
        this.kode_baliho3 = kode_baliho3;
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

    public String getBatas_pembayaran() {
        return batas_pembayaran;
    }

    public void setBatas_pembayaran(String batas_pembayaran) {
        this.batas_pembayaran = batas_pembayaran;
    }

    public String getTanggal_mulai() {
        return tanggal_mulai;
    }

    public void setTanggal_mulai(String tanggal_mulai) {
        this.tanggal_mulai = tanggal_mulai;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLamaSewa() {
        return lamaSewa;
    }

    public void setLamaSewa(int lamaSewa) {
        this.lamaSewa = lamaSewa;
    }

    public void tambahDataPesanPrepared(DBpesan dataPesan) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn.setAutoCommit(false);
            String sql = "insert into data_pemesanan(kode_pesan,kode_baliho1,kode_baliho2"
                    + ",kode_baliho3,nama_customer,alamat_customer,nama_perusahaan"
                    + ",alamat_perusahaan,batas_pembayaran,tanggal_mulai,no_telp,email,lama_sewa)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dataPesan.getKode_pesan());
            pstmt.setString(2, dataPesan.getKode_baliho1());
            pstmt.setString(3, dataPesan.getKode_baliho2());
            pstmt.setString(4, dataPesan.getKode_baliho3());
            pstmt.setString(5, dataPesan.getNama_customer());
            pstmt.setString(6, dataPesan.getAlamat_customer());
            pstmt.setString(7, dataPesan.getNamaPerusahaan());
            pstmt.setString(8, dataPesan.getAlamatPerusahaan());
            pstmt.setString(9, dataPesan.getBatas_pembayaran());
            pstmt.setString(10, dataPesan.getTanggal_mulai());
            pstmt.setString(11, dataPesan.getNoHp());
            pstmt.setString(12, dataPesan.getEmail());
            pstmt.setInt(13, dataPesan.getLamaSewa());
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
}
