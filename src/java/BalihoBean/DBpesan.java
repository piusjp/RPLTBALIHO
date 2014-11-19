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
    private String kode_pesan,kode_baliho,id_customer,nama,alamat,namaPerusahaan,alamatPerusahaan,noHp,email;
    private Date tanggalSewa;
    private int lamaSewa;
    Connection conn;

    public DBpesan() {
        Datahandler dataHandler = new Datahandler();
        dataHandler.getDBConnection();
        conn = dataHandler.conn;
    }
    
    public int getLamaSewa() {
        return lamaSewa;
    }

    public void setLamaSewa(int lamaSewa) {
        this.lamaSewa = lamaSewa;
    }
    
    public String getKode_pesan() {
        return kode_pesan;
    }

    public void setKode_pesan(String kode_pesan) {
        this.kode_pesan = kode_pesan;
    }

    public String getKode_baliho() {
        return kode_baliho;
    }

    public void setKode_baliho(String kode_baliho) {
        this.kode_baliho = kode_baliho;
    }
    
    public String getId_customer() {
        return id_customer;
    }

    public void setId_customer(String id_customer) {
        this.id_customer = id_customer;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
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

    public Date getTanggalSewa() {
        return tanggalSewa;
    }

   public void setTanggalSewa(Date tanggalSewa) {
        this.tanggalSewa = tanggalSewa;
    }

    public void tambahDataPesanPrepared(DBpesan dataPesan) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn.setAutoCommit(false);
            String sql = "insert into data_pemesanan(kode_pesan,kode_baliho"
                    + ",id_customer,nama_customer,alamat_customer,nama_perusahaan"
                    + ",alamat_perusahaan,batas_pembayaran,tanggal_mulai,no_telp,email,lama_sewa)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dataPesan.getKode_pesan());
            pstmt.setString(2, dataPesan.getKode_baliho());
            pstmt.setString(3, dataPesan.getId_customer());
            pstmt.setString(4, dataPesan.getNama());
            pstmt.setString(5, dataPesan.getAlamat());
            pstmt.setString(6, dataPesan.getNamaPerusahaan());
            pstmt.setString(7, dataPesan.getAlamatPerusahaan());
            pstmt.setDate(8, (java.sql.Date) dataPesan.getTanggalSewa());
            pstmt.setDate(9, (java.sql.Date) dataPesan.getTanggalSewa());
            pstmt.setString(10, dataPesan.getNoHp());
            pstmt.setString(11, dataPesan.getEmail());
            pstmt.setInt(12, dataPesan.getLamaSewa());
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
