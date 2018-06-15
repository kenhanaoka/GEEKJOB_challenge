package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

/**
 *
 * @author Ken Hanaoka
 */
public class InsertRecord extends HttpServlet {

//入力フォームに入力された情報をデータベースに格納する//
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");
            int age = Integer.parseInt(request.getParameter("age"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date birthday = new java.sql.Date(sdf.parse(request.getParameter("birthday")).getTime());
            out.print(name + tel + age + birthday);
            
            
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GEEKJOB_db?characterEncoding=UTF-8&serverTimezone=JST","KENHANAOKA","kamehameha99");
           
            db_st = db_con.prepareStatement("insert into profiles values(?,?,?,?,?)");
            db_st.setInt(1, 6);
            db_st.setString(2, name);
            db_st.setString(3, tel);
            db_st.setInt(4, age);
            db_st.setDate(5, birthday);
            db_st.executeUpdate();
            
            db_st = db_con.prepareStatement("select * from profiles");
            db_data = db_st.executeQuery();
            
            if(db_data != null) {
                while(db_data.next()) {
                    out.println(db_data.getInt("profilesID") + " " + db_data.getString("name") + " " + db_data.getString("tel") + " " + db_data.getInt("age") + " " + db_data.getDate("birthday"));
                }
            }
            else {
                out.print("見つかりません");
            }
            
            db_con.close();
            db_st.close();
            db_data.close();
            
            
        }
        catch (SQLException e_sql) {
            PrintWriter out = response.getWriter();
            out.print("接続エラー" +e_sql.toString());
        }
        catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.print("接続エラー" +e.toString());
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
