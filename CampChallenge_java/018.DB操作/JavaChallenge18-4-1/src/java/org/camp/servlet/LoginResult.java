package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ken Hanaoka
 */
public class LoginResult extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            
            //ログイン情報を受け取りDTOに格納，セッション格納//
            UserDTO dto = new UserDTO();
            dto.setName(request.getParameter("name").trim());
            dto.setPassword(request.getParameter("password").trim());
            dto.setSubmit(request.getParameter("submit").trim());
            System.out.print(dto.getName());
            System.out.print(dto.getPassword());
            System.out.print(dto.getSubmit());
            
            HttpSession hs = request.getSession();
            hs.setAttribute("name", dto.getName());
            hs.setAttribute("password", dto.getPassword());
            hs.setAttribute("submit", dto.getSubmit());
            
            //ログインボタン：ログイン成功か失敗か判定し，その結果をセッションに格納して結果画面に遷移//
            UserDAO dao = new UserDAO();
            if (dto.getSubmit().equals("login")) {
                if (dao.judgment(dto)) {
                    hs.setAttribute("decision", true);
                    request.getRequestDispatcher("/LoginResult.jsp").forward(request,response);
                }
                else {
                    hs.setAttribute("decision", false);
                    request.getRequestDispatcher("/LoginResult.jsp").forward(request,response);
                }
            }
            
            //ログアウトボタン：ログアウト画面に遷移//
            if (dto.getSubmit().equals("logout")){
                request.getRequestDispatcher("/Logout.jsp").forward(request,response);                
            }

        }
        catch (SQLException e) {
            PrintWriter out = response.getWriter();
            out.print("接続エラー:" + e.getMessage());
            e.printStackTrace(out);
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