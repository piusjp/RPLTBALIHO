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
import java.util.Date;

/**
 *
 * @author HP
 */
public class DBpesan {

    private String kode_pesan, kode_baliho,
            nama_customer, alamat_customer, namaPerusahaan, alamatPerusahaan,
            batas_pembayaran, tanggal_mulai, no_telp, email;
    private int lamaSewa;
    Connection conn;

    public DBpesan() {
        Datahandler dataHandler = new Datahandler();
        dataHandler.getDBConnection();
        conn = dataHandler.conn;
    }

    public String getKode_pesan() {
        String code = "" + getNama_customer().charAt(0)
                + getNama_customer().charAt(getNama_customer().length() - 1)
                + getEmail().charAt(getEmail().length() / 2) + getNo_telp().substring(0, 2);
        return code;
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
            String sql = "insert into data_pemesanan(kode_pesan,kode_baliho,nama_customer,alamat_customer,"
                    + "nama_perusahaan,alamat_perusahaan,batas_pembayaran,tanggal_mulai,no_telp,email,lama_sewa)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dataPesan.getKode_pesan());
            pstmt.setString(2, dataPesan.getKode_baliho());
            pstmt.setString(3, dataPesan.getNama_customer());
            pstmt.setString(4, dataPesan.getAlamat_customer());
            pstmt.setString(5, dataPesan.getNamaPerusahaan());
            pstmt.setString(6, dataPesan.getAlamatPerusahaan());
            pstmt.setString(7, dataPesan.getBatas_pembayaran());
            pstmt.setString(8, dataPesan.getTanggal_mulai());
            pstmt.setString(9, dataPesan.getNo_telp());
            pstmt.setString(10, dataPesan.getEmail());
            pstmt.setInt(11, dataPesan.getLamaSewa());
            pstmt.executeUpdate();
            DBbaliho db=new DBbaliho();
            conn.commit();
            db.updateDipesan(dataPesan.getKode_baliho());
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
    
    public String search(String keyword, String searchData) throws SQLException, Exception {

        Datahandler dataHandler = new Datahandler();
        dataHandler.getDBConnection();
        Connection conn = dataHandler.conn;
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String query = "select * from data_pemesanan where KODE_PESAN='" + keyword + "'";

        ResultSet rset = stmt.executeQuery(query);
        String seacrh = "";
        while (rset.next()) {
            seacrh = rset.getString(searchData);
        }
        return seacrh;
    }
}
