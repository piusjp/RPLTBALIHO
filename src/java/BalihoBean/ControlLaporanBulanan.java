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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dion Wisnu
 */
public class ControlLaporanBulanan {
    Connection conn;

//    public List<DBtransaksi> lihatLaporanBulanan(String bulan, String tahun) throws SQLException {
//        PreparedStatement pstmt = null;
//        ResultSet result = null;
//        try {
////            conn.setAutoCommit(false);
//            String sql = "select tanggal_bayar from data_transaksi where tanggal_bayar like '%"+bulan+"%' AND tanggal_bayar like '%"+tahun+"'";
////            String sql = "select dt.tanggal_bayar, db.kode_baliho, db.lokasi, dp.nama_customer, dp.tanggal_mulai, dp.tanggal_berakhir, dt.total_bayar"
////                    + "from data_transaksi dt, data_baliho db, data_penyewaan dp"
////                    + "where dt.tanggal_bayar = '%?%' AND dt.tanggal_bayar like '%?'"
////                    + "AND dt.kode_sewa=dp.kode_sewa AND dp.kode_baliho=db.kode_baliho"
////                    + "order by dt.tanggal_bayar";
//            pstmt = conn.prepareStatement(sql);
////            pstmt.setString(1, bulan);
////            pstmt.setString(2, tahun);
//            result = pstmt.executeQuery();
//            List<DBtransaksi> listPenyewaan = new ArrayList<DBtransaksi>();
//            while (result.next()) {
////                DBsewa dataPenyewaan = new DBsewa();
////                DBbaliho dataBaliho = new DBbaliho();
//                DBtransaksi dataTransaksi = new DBtransaksi();
////                dataTransaksi.setTanggal_bayar(result.getString("tanggal_bayar"));
////                dataBaliho.setKodeBaliho(result.getString("kode_baliho"));
////                dataBaliho.setLokasi(result.getString("lokasi"));
////                dataPenyewaan.setNama_customer(result.getString("nama_customer"));
////                dataPenyewaan.setTanggal_mulai(result.getString("tanggal_mulai"));
////                dataPenyewaan.setTanggal_berakhir(result.getString("tanggal_berakhir"));
//                dataTransaksi.setTotal_bayar(result.getInt("total_bayar"));
//                listPenyewaan.add(dataTransaksi);
//            }
//            conn.commit();
//            return listPenyewaan;
//        } catch (SQLException exception) {
//            throw exception;
//        }
//    }
    
    public void lihatLaporanBulanan(String bulan, String tahun) throws SQLException {
        //PreparedStatement pstmt = null;
         Statement statement = null;
        ResultSet result;
        try {
//            conn.setAutoCommit(false);
//            String sql = "select * from employees";
            String sql = "select tanggal_bayar, total_bayar from data_transaksi where tanggal_bayar like '%"+bulan+"%' AND tanggal_bayar like '%"+tahun+"'";
//            String sql = "select dt.tanggal_bayar, db.kode_baliho, db.lokasi, dp.nama_customer, dp.tanggal_mulai, dp.tanggal_berakhir, dt.total_bayar"
//                    + "from data_transaksi dt, data_baliho db, data_penyewaan dp"
//                    + "where dt.tanggal_bayar = '%?%' AND dt.tanggal_bayar like '%?'"
//                    + "AND dt.kode_sewa=dp.kode_sewa AND dp.kode_baliho=db.kode_baliho"
//                    + "order by dt.tanggal_bayar";
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, bulan);
//            pstmt.setString(2, tahun);
//            result = pstmt.executeQuery(sql);
            result = statement.executeQuery(sql);
//            List<DBtransaksi> listPenyewaan = new ArrayList<DBtransaksi>();
            while (result.next()) {
//                DBsewa dataPenyewaan = new DBsewa();
//                DBbaliho dataBaliho = new DBbaliho();
                DBtransaksi dataTransaksi = new DBtransaksi();
//                dataTransaksi.setTanggal_bayar(result.getString("tanggal_bayar"));
//                dataBaliho.setKodeBaliho(result.getString("kode_baliho"));
//                dataBaliho.setLokasi(result.getString("lokasi"));
//                dataPenyewaan.setNama_customer(result.getString("nama_customer"));
//                dataPenyewaan.setTanggal_mulai(result.getString("tanggal_mulai"));
//                dataPenyewaan.setTanggal_berakhir(result.getString("tanggal_berakhir"));
                dataTransaksi.setTotal_bayar(result.getInt("total_bayar"));
//                listPenyewaan.add(dataTransaksi);
            }
            conn.commit();
            
        } catch (SQLException exception) {
            throw exception;
        }
    }
    
    public void laporan() throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;
        System.out.println("Masuk method");
        try {
            statement = conn.prepareStatement("select * from data_transaksi");
            result = statement.executeQuery();
            while(result.next()){
                DBtransaksi tran = new DBtransaksi();
                tran.setTotal_bayar(result.getInt("total_bayar"));
            }
            conn.commit();
            System.out.println("Berhasil");
        } catch (SQLException exception) {
            conn.rollback();
            System.out.println("gagal :" + exception.getMessage());
            throw exception;
        }
    }
    
    
}
