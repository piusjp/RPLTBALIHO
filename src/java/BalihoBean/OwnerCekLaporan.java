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
        boolean status;
        
        if (bulanPilih.equals("januari")) {
            bulan = "JAN";
        } else if (bulanPilih.equals("februari")) {
            bulan = "FEB";
        } else if (bulanPilih.equals("maret")) {
            bulan = "MAR";
        } else if (bulanPilih.equals("april")) {
            bulan = "APR";
        } else if (bulanPilih.equals("mei")) {
            bulan = "MAY";
        } else if (bulanPilih.equals("juni")) {
            bulan = "JUN";
        } else if (bulanPilih.equals("juli")) {
            bulan = "JUL";
        } else if (bulanPilih.equals("agustus")) {
            bulan = "AUG";
        } else if (bulanPilih.equals("september")) {
            bulan = "SEP";
        } else if (bulanPilih.equals("oktober")) {
            bulan = "OCT";
        } else if (bulanPilih.equals("november")) {
            bulan = "NOV";
        } else if (bulanPilih.equals("desember")) {
            bulan = "DEC";
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
            ControlLaporanBulanan laporanBulanan = new ControlLaporanBulanan();
            try {
                status = laporanBulanan.cekBulan(bulan, tahun);
                if (status == true) {
                    HttpSession session = request.getSession();
                    session.setAttribute("plhBln", bulan);
                    session.setAttribute("plhThn", tahun);
                    response.sendRedirect("OwnerLaporanBulanan.jsp");
                } else {
                    response.sendRedirect("OwnerPilihPeriode.jsp?error=y");
                }
            } catch (SQLException ex) {
                response.sendRedirect("OwnerPilihPeriode.jsp?error=y");
            } catch (NullPointerException nul) {
                response.sendRedirect("OwnerPilihPeriode.jsp?error=y");
            }

        }
    }

}
