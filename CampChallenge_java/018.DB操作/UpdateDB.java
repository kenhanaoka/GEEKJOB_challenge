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
public class UpdateDB {
    
    //データベースに接続し，profilesIDの1のレコードの他のカラムの値を更新する//
    public static void main(String[] args) {
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        try {
            
            
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GEEKJOB_db?characterEncoding=UTF-8&serverTimezone=JST","KENHANAOKA","kamehameha99");
            
            Calendar cl = Calendar.getInstance();
            cl.set(1995,2,27);
            java.sql.Date birthday = new java.sql.Date(cl.getTimeInMillis());
            
            db_st = db_con.prepareStatement("update profiles set name = ?,age = ?,tel = ?,birthday = ? where age = ?" );
            db_st.setString(1, "花岡憲");
            db_st.setInt(2,23);
            db_st.setString(3, "161-4648-4941");
            db_st.setDate(4,birthday);
            db_st.setInt(5,37);
            
            int count = db_st.executeUpdate();
            
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
