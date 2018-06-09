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
public class primeFactor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //クエリストリングから得られた値を素因数分解し画面に表示//
        try (PrintWriter out = response.getWriter()) {
            response.setCharacterEncoding("UTF-8");
            int num = Integer.valueOf(request.getParameter("num"));
            ArrayList<Integer> primeFactors= new ArrayList<Integer>();
            
            String display = num + "=";
            
            //値を2で割り切れなくなるまで繰り返し割り，その回数分だけ因数の配列に2を格納//
            while (num != 1 && num % 2 == 0) {
                num /= 2;
                primeFactors.add(2);
            }
            //3以上の奇数について上と同様の処理//
            for (int i = 3 ; i * i <= num ; i += 2 ) {
                while (num % i == 0) {
                    num /= i;
                    primeFactors.add(i);
                }
            }
            
            
            for(int j = 0 ; j < primeFactors.size(); j++) {
                display = display + primeFactors.get(j) + "*";    
            }
            //if (primeFactors.size() <= 1 ) {
                out.print(display + num);
            //}
            //else { 
            //}
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
