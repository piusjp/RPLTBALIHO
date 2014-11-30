/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BalihoBean;

import com.sun.corba.se.impl.orbutil.ORBConstants;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
public class tes {

    public static void main(String[] args) throws SQLException, Exception {
//        DBbaliho d=new DBbaliho("ee", "AA", "AA", "1",200);
//        d.TambahBaliho();
//        d.createTable();
//        DBbaliho d=new DBbaliho();
//        System.out.println(d.hitungDataBaliho());
//        d.hitungDataBaliho();
//        System.out.println(d.search("Baliho1", "LOKASI"));
//        ArrayList a=new ArrayList();
//        a.add("1");
//        a.add("2");
//        a.add("3");
//        System.out.println(a);
//        for (int i = 0; i < a.size(); i++) {
//            System.out.println(a.get(i));
//        }
//        System.out.println();
//        for (int i = 0; i < a.size(); i++) {
//            if(a.get(i).equals("1"))
//                a.remove(i);
//        }
//        for (int i = 0; i < a.size(); i++) {
//            System.out.println(a.get(i));
//        }

//        Date date = new Date();
//        Date tomorrow = new Date(date.getTime() + (1000 * 60 * 60 * 24));
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
//        System.out.println(sdf.format(tomorrow));
//        DBpesan d = new DBpesan();
//        d.setNama_customer("a");
//        d.setAlamat_customer(("alamat"));
//        d.setNamaPerusahaan(("perusahaan"));
//        d.setAlamatPerusahaan(("alamatp"));
//        d.setBatas_pembayaran("30-dec-1994");
//        d.setTanggal_mulai("30-dec-1994");
//        d.setNo_telp(("hp"));
//        d.setEmail(("email"));
//        d.setLamaSewa((10));
//        d.tambahDataPesanPrepared(d);
//        DBtransaksi d=new DBtransaksi();
//        System.out.println(d.CekNobar("34"));d.CekNobar("34");
//        
        DBtransaksi transaksi = new DBtransaksi();
//        System.out.println(transaksi.search("34","kode_sewa").substring(0,5));
//        String kode_pesan = transaksi.search("34", "kode_sewa").substring(0, 5);
//        DBpesan d=new DBpesan();
//        System.out.println(d.search(kode_pesan, "nama_customer"));d.search(kode_pesan, "nama_customer");
//        

//        DBsewa sewa = new DBsewa();
//        sewa.setKode_sewa("a");
//        sewa.setKode_baliho("a");
//        sewa.setNama_customer("a");
//        sewa.setAlamat_customer("a");
//        sewa.setNamaPerusahaan("a");
//        sewa.setAlamatPerusahaan("a");
//        sewa.setTanggal_mulai("a");
//        sewa.setTanggal_berakhir("a");
//        sewa.setNo_telp("a");
//        sewa.setEmail("a");
//        sewa.tambahDataSewaPrepared(sewa);
//        DBpesan pesan=new DBpesan();
//        String kode_pesan = transaksi.search("34", "kode_sewa").substring(0, 5);
//        System.out.println(kode_pesan);
//        System.out.println(pesan.hitungPesan(kode_pesan));
        
        Datahandler dh = new Datahandler();
        dh.getDBConnection();
        ControlLaporanBulanan lprnBln = new ControlLaporanBulanan();
        try {
//            lprnBln.lihatLaporanBulanan("NOV", "14");
            lprnBln.laporan();
            System.out.println("Berhasil ");
        } catch (SQLException ex) {
            System.out.println("gagal : " + ex.getMessage());
        }
    }
}
