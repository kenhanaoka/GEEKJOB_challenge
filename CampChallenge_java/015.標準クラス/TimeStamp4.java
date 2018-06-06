package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParsePosition;

/**
 *
 * @author Ken Hanaoka
 */
public class TimeStamp4 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* 2015年1月1日 0時0分0秒と2015年12月31日 23時59分59秒の差（ミリ秒）を表示*/
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            ParsePosition pos1 = new ParsePosition(0);
            ParsePosition pos2 = new ParsePosition(0);
            Date dayFrom = sdf.parse("2015/01/01 00:00:00",pos1);
            Date dayTo = sdf.parse("2015/12/31 23:59:59",pos2);
            out.print(sdf.format(dayFrom.getTime()) + "<br>");
            out.print(sdf.format(dayTo.getTime()) + "<br>");
            long dayDifference = dayTo.getTime()-dayFrom.getTime();
            out.println(dayDifference);
            
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
