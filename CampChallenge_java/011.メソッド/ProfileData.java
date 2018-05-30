/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

/**
 *
 * @author Ken Hanaoka
 */
public class ProfileData extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //ID，生年月日，住所の格納された配列を3コつくり，引数とIDが合致する配列を返すメソッド//
    ArrayList<String> myprofile(String id) {
        
        ArrayList<String> data1= new ArrayList<String>();
        ArrayList<String> data2= new ArrayList<String>();
        ArrayList<String> data3= new ArrayList<String>();
        data1.add("a1");
        data1.add("1995年3月27日");
        data1.add("東京都小金井市");
        data2.add("a2");
        data2.add("1975年4月17日");
        data2.add("長野県諏訪市");
        data3.add("a3");
        data3.add("1998年1月16日");
        data3.add("北海道札幌市");
        
        if (data1.get(0).equals(id)) {
            return data1;
        }
        else if (data2.get(0).equals(id)) {
            return data2;
        }
        else {
            return data3;
        }
     }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //IDを指定し，そのIDと合致しているプロフィールをメソッドにより取得し画面に表示する//
            String id  = "a2";
            out.print(myprofile(id));
            
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
