package org.java.connectionDB;

import java.util.Calendar;
import java.sql.*;

/**
 *
 * @author Ken Hanaoka
 */
//mysqlに接続し，レコード（ID，名前，電話番号，歳，誕生日)を追加する．
public class ConnectionDB {
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
           
            db_st = db_con.prepareStatement("insert into profiles values(?,?,?,?,?)");
            db_st.setInt(1, 6);
            db_st.setString(2, "花岡憲");
            db_st.setString(3, "015-5461-5648");
            db_st.setInt(4,23);
            db_st.setDate(5,birthday);  
            
            int count = db_st.executeUpdate();
            
            db_st = db_con.prepareStatement("select * from profiles where age = ?");
            db_st.setInt(1,23);
            db_data = db_st.executeQuery();
            while(db_data.next()) {
                System.out.println(db_data.getString("name"));
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
