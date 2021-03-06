package org.camp.setvlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Ken Hanaoka
 */
public class CookieTime extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //クッキーを用いてアクセスした日時を記録し，前回アクセス時の日時を表示//
            SimpleDateFormat sdf = new SimpleDateFormat();
            Date loginTime = new Date();
            Cookie c = new Cookie("Data",sdf.format(loginTime)); 
            response.addCookie(c);
            
            Cookie[] cs = request.getCookies();
            if (cs != null) {
                for(Cookie i:cs) {
                    String cookieName = i.getName();
                    if (cookieName.equals("Data")) {
                        String cookieValue = i.getValue();
                    out.print(cookieValue);
                    break;
                    }
                }
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
