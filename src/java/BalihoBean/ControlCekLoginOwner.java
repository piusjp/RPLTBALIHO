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
@WebServlet(name = "ControlCekLoginOwner", urlPatterns = {"/ControlCekLoginOwner"})
public class ControlCekLoginOwner extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String inUsername = request.getParameter("username");
        String inPassword = request.getParameter("password");

        if (inUsername.equals("bias") && inPassword.equals("bias")){
            response.sendRedirect("FormMenuOwner.jsp");
        } else {
            response.sendRedirect("FormLoginOwner.jsp?error=y");
        }
    }
}
