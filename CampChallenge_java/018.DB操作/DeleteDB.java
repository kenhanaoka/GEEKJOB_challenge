package org.java.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ken Hanaoka
 */
//データベースに接続し，別課題で追加したレコードを削除する//
public class DeleteDB {
     public static void main(String[] args) {
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        try {
            
            
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GEEKJOB_db?characterEncoding=UTF-8&serverTimezone=JST","KENHANAOKA","kamehameha99");
            
            db_st = db_con.prepareStatement("delete from profiles where age = ?");
            db_st.setInt(1,23);
            int count = db_st.executeUpdate();
            
            
            db_con.close();;
            db_st.close();
            db_data.close();
        }
        
        catch (SQLException e_sql) {
            System.out.print("接続エラー" +e_sql.toString());
        }
        catch (Exception e) {
            System.out.print("接続エラー" +e.toString());
        }
            
    }
    
}
