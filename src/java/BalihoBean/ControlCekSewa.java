/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BalihoBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
public class ControlCekSewa extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        DBtransaksi transaksi = new DBtransaksi();
        DBsewa sewa = new DBsewa();
        DBpesan pesan = new DBpesan();
        String nobar = request.getParameter("nobar");
        try {
            if (transaksi.CekNobar(nobar) == 1) {
                String kode_pesan = transaksi.search(nobar, "kode_sewa").substring(0, 5);
//                for (int i = 0; i < pesan.hitungPesan(kode_pesan); i++) {
                    sewa.setKode_sewa(transaksi.search(nobar, "kode_sewa"));
                    sewa.setKode_baliho("a");
                    sewa.setNama_customer(pesan.search(kode_pesan, "nama_customer"));
                    sewa.setAlamat_customer(pesan.search(kode_pesan, "alamat_customer"));
                    sewa.setNamaPerusahaan(pesan.search(kode_pesan, "nama_perusahaan"));
                    sewa.setAlamatPerusahaan(pesan.search(kode_pesan, "alamat_perusahaan"));
                    sewa.setTanggal_mulai(pesan.search(kode_pesan, "tanggal_mulai"));
                    sewa.setTanggal_berakhir(pesan.search(kode_pesan, "tanggal_mulai"));
                    sewa.setNo_telp(pesan.search(kode_pesan, "no_telp"));
                    sewa.setEmail(pesan.search(kode_pesan, "email"));
                    sewa.tambahDataSewaPrepared(sewa);
//                }
                RequestDispatcher disp = request.getRequestDispatcher("/BalihoTersewa.jsp");
                disp.forward(request, response);
            } else {
                RequestDispatcher disp = request.getRequestDispatcher("/CekSewa.jsp");
                disp.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlCekSewa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControlCekSewa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
