/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Ken Hanaoka
 */
public class ProductRegistration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //フォームの入力値をDTOにセット
            UserDTO dto = new UserDTO();
            dto.setProductName(request.getParameter("productName"));
            dto.setProductPrice(Integer.parseInt(request.getParameter("productPrice")));
            dto.setProductType(request.getParameter("productType"));
            
            //未入力欄のリストを作成
            UserDAO dao = new UserDAO();
            String chk = dao.checkList(dto);
            
            //未入力箇所なければ商品登録する
            if(chk == null) {
                dao.productInsert(dto);
            }
            
            //セッションにDTOの値と未入力欄のリストをセット
            HttpSession hs = request.getSession();
            hs.setAttribute("productName", dto.getProductName());
            hs.setAttribute("productPrice", dto.getProductPrice());
            hs.setAttribute("productType", dto.getProductType());
            hs.setAttribute("checkList", chk);
            request.getRequestDispatcher("/ProductRegistrationResult.jsp");
        }
        catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.print(e.getMessage());
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
