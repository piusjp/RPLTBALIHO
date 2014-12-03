/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BalihoBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class ControlCheckOut extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        DBpesan pesan = new DBpesan();
        HttpSession session = request.getSession();
        ArrayList<DBpesan> isiCart = (ArrayList<DBpesan>) session.getAttribute("cart");
        
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        Date tomorrow = new Date(date.getTime() + (1000 * 60 * 60 * 48));
        
        for (int i = 0; i < isiCart.size(); i++) {
            pesan.setKode_baliho((String) isiCart.get(i).getKode_baliho());
            pesan.setNama_customer(request.getParameter("nama"));
            pesan.setAlamat_customer(request.getParameter("alamat"));
            pesan.setNamaPerusahaan(request.getParameter("namaP"));
            pesan.setAlamatPerusahaan(request.getParameter("alamatP"));
            pesan.setBatas_pembayaran(sdf.format(tomorrow));
            pesan.setTanggal_mulai(request.getParameter("mulai"));
            pesan.setNo_telp(request.getParameter("no_telp"));
            pesan.setEmail(request.getParameter("email"));
            pesan.setLamaSewa(isiCart.get(i).getLamaSewa());
            try {
                pesan.tambahDataPesanPrepared(pesan);
            } catch (SQLException ex) {
                Logger.getLogger(ControlCheckOut.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        RequestDispatcher disp = request.getRequestDispatcher("/PesanBaliho.jsp");
        disp.forward(request, response);

    }
}
