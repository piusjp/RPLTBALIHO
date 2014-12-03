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
public class ControlCart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //dionbekasi
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        ArrayList<ControlCart> cart = new ArrayList<ControlCart>();
        ArrayList<ControlCart> b = (ArrayList<ControlCart>) session.getAttribute("cart");

        String kb = request.getParameter("kode");
        String ls = request.getParameter("lamaSewa");
        ControlCart c=new ControlCart();
        c.setKodeBaliho(kb);
        c.setLamaSewa(ls);
        if (session.getAttribute("cart") == null) {
            cart.add(c);
        } else {
            cart.add(c);
            for (int i = 0; i < b.size(); i++) {
                cart.add(b.get(i));
            }
        }
        session.setAttribute("cart", cart);
        RequestDispatcher disp = request.getRequestDispatcher("/PesanBaliho.jsp");
        disp.forward(request, response);
    }
    private String kodeBaliho;
    private String lamaSewa;

    public String getKodeBaliho() {
        return kodeBaliho;
    }

    public void setKodeBaliho(String kodeBaliho) {
        this.kodeBaliho = kodeBaliho;
    }

    public String getLamaSewa() {
        return lamaSewa;
    }

    public void setLamaSewa(String lamaSewa) {
        this.lamaSewa = lamaSewa;
    }
    
    
}
