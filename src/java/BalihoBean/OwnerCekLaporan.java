/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BalihoBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.http.Cookies;

/**
 *
 * @author Dion Wisnu
 */
public class OwnerCekLaporan extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bulanPilih = request.getParameter("pilihBulan");
        String tahunPilih = request.getParameter("pilihTahun");
        String bulan = null;
        String tahun = null;

        if (bulanPilih.equals("januari")) {
            bulan = "jan";
        } else if (bulanPilih.equals("februari")) {
            bulan = "feb";
        } else if (bulanPilih.equals("maret")) {
            bulan = "mar";
        } else if (bulanPilih.equals("april")) {
            bulan = "apr";
        } else if (bulanPilih.equals("mei")) {
            bulan = "may";
        } else if (bulanPilih.equals("juni")) {
            bulan = "jun";
        } else if (bulanPilih.equals("juli")) {
            bulan = "jul";
        } else if (bulanPilih.equals("agustus")) {
            bulan = "aug";
        } else if (bulanPilih.equals("september")) {
            bulan = "sep";
        } else if (bulanPilih.equals("oktober")) {
            bulan = "oct";
        } else if (bulanPilih.equals("november")) {
            bulan = "nov";
        } else if (bulanPilih.equals("desember")) {
            bulan = "dec";
        }

        if (tahunPilih.equals("2012")) {
            tahun = "12";
        } else if (tahunPilih.equals("2013")) {
            tahun = "13";
        } else if (tahunPilih.equals("2014")) {
            tahun = "14";
        } else if (tahunPilih.equals("2015")) {
            tahun = "15";
        }

        if (request.getParameter("submitLaporan").equals("Submit")) {
            HttpSession session = request.getSession();
            session.setAttribute("plhBln", bulanPilih);
            session.setAttribute("plhThn", tahunPilih);
            try{
                ControlLaporanBulanan laporanBulanan = new ControlLaporanBulanan();
                laporanBulanan.lihatLaporanBulanan(bulan, tahun);
                response.sendRedirect("OwnerLaporanBulanan.jsp?laporan=y");
            } catch (SQLException ex){
                response.sendRedirect("OwnerLaporanBulanan.jsp?laporan=n");
            }
            
        }
    }

}
