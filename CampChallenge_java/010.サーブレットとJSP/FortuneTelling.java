package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

import java.util.Date;
import javax.servlet.RequestDispatcher;
import org.camp.servlet.ResultData;


public class FortuneTelling extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            // 大吉・中吉・小吉・吉・半吉・末半吉・凶・小凶・半凶・末凶・大凶 //
            String luckList[] = {"大吉","中吉","小吉","吉","半吉","末半吉","凶","小凶","半凶","末凶","大凶"};
            // 乱数クラス生成 //
            Random rand = new Random();
            // luckListの要素数分の整数乱数取得して表示 //
            Integer index = rand.nextInt(luckList.length);
            out.print(luckList[index]);
           
            //日付と占い結果を記録//
            ResultData data = new ResultData();
            data.setD(new Date());
            data.setLuck(luckList[index]);
            //結果をリクエストスコープに登録//
            request.setAttribute("DATA", data);
            //jSPのパス//
            String result = "/WEB-INF/jsp/FortuneTellingResult.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(result);
            rd.forward(request,response);
            
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
