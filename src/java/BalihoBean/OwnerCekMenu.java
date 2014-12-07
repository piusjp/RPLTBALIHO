/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BalihoBean;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dion Wisnu
 */
@WebServlet(name = "ControlCekMenuOwner", urlPatterns = {"/ControlCekMenuOwner"})
public class OwnerCekMenu extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tombolOwner = request.getParameter("tombolMenuOwner");

        if (tombolOwner.equals("Lihat Baliho")) {
            response.sendRedirect("OwnerLihatBaliho.jsp");
        } else if (tombolOwner.equals("Laporan Bulanan")) {
            response.sendRedirect("OwnerLaporanBulanan.jsp");
        } else if (tombolOwner.equals("Logout")) {
            response.sendRedirect("Home.html");
        } else if (tombolOwner.equals("Menu Utama")) {
            response.sendRedirect("OwnerFormMenu.jsp");
        }
    }

}
