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
import oracle.sql.DATE;

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
        ArrayList isiCart = (ArrayList) session.getAttribute("cart");

            pesan.setKode_pesan("a");
            pesan.setKode_baliho("a");
            pesan.setId_customer("a");
            pesan.setNama(request.getParameter("nama"));
            pesan.setAlamat(request.getParameter("alamat"));
            pesan.setNamaPerusahaan(request.getParameter("perusahaan"));
            pesan.setAlamatPerusahaan(request.getParameter("alamatp"));
            pesan.setNoHp(request.getParameter("hp"));
            pesan.setEmail(request.getParameter("email"));
            pesan.setLamaSewa(Integer.parseInt(request.getParameter("lama")));
            try {
                pesan.tambahDataPesanPrepared(pesan);
            } catch (SQLException ex) {
                Logger.getLogger(ControlCheckOut.class.getName()).log(Level.SEVERE, null, ex);
            }
        

        RequestDispatcher disp = request.getRequestDispatcher("/PesanBaliho.jsp");
        disp.forward(request, response);

    }
}
