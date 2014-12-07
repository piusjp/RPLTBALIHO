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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dion Wisnu
 */
public class ControlLaporanBulanan {

    Connection conn;

    public ControlLaporanBulanan() {
        Datahandler dataHandler = new Datahandler();
        dataHandler.getDBConnection();
        conn = dataHandler.conn;
    }

    public List<DBtransaksi> lihatLaporanBulanan(String bulan, String tahun) throws SQLException {
        Datahandler dh = new Datahandler();

        PreparedStatement pstmt = null;
        ResultSet result = null;
        try {
            conn.setAutoCommit(false);
            String sql = "select dt.tanggal_bayar, dp.nama_customer, db.kode_baliho, db.lokasi ,dp.tanggal_mulai, dp.tanggal_berakhir, dt.total_bayar "
                    + "from data_transaksi dt, data_penyewaan dp, data_baliho db "
                    + "where dt.kode_sewa = dp.kode_sewa AND dp.kode_baliho = db.kode_baliho "
                    + "AND dt.tanggal_bayar like '%"+bulan+"%' AND dt.tanggal_bayar like '%"+tahun+"' "
                    + "order by dt.tanggal_bayar";
            pstmt = conn.prepareStatement(sql);
            result = pstmt.executeQuery();
            List<DBtransaksi> listPenyewaan = new ArrayList<DBtransaksi>();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
            while (result.next()) {
                DBsewa dataPenyewaan = new DBsewa();
                DBbaliho dataBaliho = new DBbaliho();
                DBtransaksi dataTransaksi = new DBtransaksi();
//                dataTransaksi.setTanggal_bayar(java.sql.Date.valueOf(result.getString("tanggal_bayar")));
                dataBaliho.setKodeBaliho(result.getString("kode_baliho"));
                dataBaliho.setLokasi(result.getString("lokasi"));
                dataPenyewaan.setKode_baliho(dataBaliho);
                dataPenyewaan.setNama_customer(result.getString("nama_customer"));
                dataPenyewaan.setTanggal_mulai(result.getString("tanggal_mulai"));
                dataPenyewaan.setTanggal_berakhir(result.getString("tanggal_berakhir"));
                dataTransaksi.setKodeSewa(dataPenyewaan);
                dataTransaksi.setTotal_bayar(result.getInt("total_bayar"));
                listPenyewaan.add(dataTransaksi);
            }
            conn.commit();
            return listPenyewaan;
        } catch (SQLException exception) {
            throw exception;
        }
    }

    public boolean cekBulan(String bulan, String tahun) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "select kode_sewa from data_transaksi where tanggal_bayar like '%" + bulan + "%' AND tanggal_bayar like '%" + tahun + "'";

        boolean status = false;
        try {
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                if (rset.getString("kode_sewa").equals("")) {
                    status = false;
                } else {
                    status = true;
                }
            }
            System.out.println("status : " + status);
            return status;
        } catch (SQLException ex) {
            System.out.println("Gagal hitung jumlah supir = " + ex.getMessage());
            return false;
        }

    }

}
