/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ken Hanaoka
 */
public class Profile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //3人のプロフィールをそれぞれArrayListに格納し，引数で指定されたIDと一致するものを返すメソッド//
    ArrayList<String> myprofile(String id,PrintWriter pw) {
        
        ArrayList<String> data1= new ArrayList<String>();
        ArrayList<String> data2= new ArrayList<String>();
        ArrayList<String> data3= new ArrayList<String>();
        
        data1.add("a1");
        data1.add("1995年3月27日");
        data1.add("東京都小金井市");
        
        data2.add("a2");
        data2.add("1975年4月17日");
        data2.add(null);
        
        data3.add("a3");
        data3.add("1998年1月16日");
        data3.add("長野県諏訪市");
        
        
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
            
            String id;
            ArrayList<String> data = new ArrayList<String>();
            int limit = 2;
            
            /*ID(a1～a3)により各人プロフィールを取り出し，画面に表示する処理．ただしnullの場合はスキップし，2人分表示した時点で終了する課題
            　3人のプロフィールの格納された配列をmyprofileメソッドにより呼び出し，要素番号0～2の配列の要素をfor文により一つずつ取り出している*/
            for(int i = 1; i <= 3; i++) {
                data = myprofile(id = "a" + String.valueOf(i),out);
                
                
                for(int j = 1; j < 3; j++) {
                    if(data.get(j) == null) {
                        continue;
                    }
                    out.println(data.get(j));
                }
                
                if (i == limit) {
                    break;
                }
                
                out.print("<br>");
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
