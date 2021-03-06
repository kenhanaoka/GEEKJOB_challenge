package org.java.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author Ken Hanaoka
 */
public class SelectDB {
    public static void main(String[] args) {
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        try {
            
            
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GEEKJOB_db?characterEncoding=UTF-8&serverTimezone=JST","KENHANAOKA","kamehameha99");
            
            db_st = db_con.prepareStatement("select * from profiles");
            db_data = db_st.executeQuery();
            while(db_data.next()) {
                System.out.println(db_data.getString("profilesID") + db_data.getString("name") + db_data.getString("tel") + db_data.getString("age") + db_data.getString("birthday"));
            }
            
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
