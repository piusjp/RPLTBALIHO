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
        String nobar = request.getParameter("nobar");
        try {
            if (transaksi.CekNobar(nobar) == 1) {
                String kode_pesan = transaksi.search(nobar, "kode_sewa").substring(0, 5);
                sewa.setKode_sewa(transaksi.search(nobar, "kode_sewa"));
                sewa.setKode_baliho((String) isiCart.get(i));
                sewa.setNama_customer(request.getParameter("nama"));
                sewa.setAlamat_customer(request.getParameter("alamat"));
                sewa.setNamaPerusahaan(request.getParameter("namaP"));
                sewa.setAlamatPerusahaan(request.getParameter("alamatP"));
                sewa.setBatas_pembayaran(sdf.format(tomorrow));
                sewa.setTanggal_mulai(request.getParameter("mulai"));
                sewa.setNo_telp(request.getParameter("no_telp"));
                sewa.setEmail(request.getParameter("email"));
                sewa.setLamaSewa(Integer.parseInt(request.getParameter("lama")));
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
