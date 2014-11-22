/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BalihoBean;

import com.sun.corba.se.impl.orbutil.ORBConstants;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        DBpesan d = new DBpesan();
        d.setNama_customer("a");
        d.setAlamat_customer(("alamat"));
        d.setNamaPerusahaan(("perusahaan"));
        d.setAlamatPerusahaan(("alamatp"));
        d.setBatas_pembayaran("30-dec-1994");
        d.setTanggal_mulai("30-dec-1994");
        d.setNo_telp(("hp"));
        d.setEmail(("email"));
        d.setLamaSewa((10));
        d.tambahDataPesanPrepared(d);
    }
}
