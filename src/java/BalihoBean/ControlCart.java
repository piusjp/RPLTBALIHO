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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        ArrayList cart = new ArrayList();
        ArrayList b = (ArrayList) session.getAttribute("PACE ASU");

        String kb = request.getParameter("kode");
        if (session.getAttribute("cart") == null) {
            cart.add(kb);
        } else {
            cart.add(kb);
            for (int i = 0; i < b.size(); i++) {
                cart.add(b.get(i));
            }
        }
        session.setAttribute("cart", cart);
        RequestDispatcher disp = request.getRequestDispatcher("/PesanBaliho.jsp");
        disp.forward(request, response);

    }
}
