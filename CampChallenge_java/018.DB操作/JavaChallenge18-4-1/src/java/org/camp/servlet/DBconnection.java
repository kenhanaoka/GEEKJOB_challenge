package org.camp.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ken Hanaoka
 */
public class DBconnection {
    //データベースに接続し，Connectionを返す//
    public static Connection getConnection() {
        Connection db_con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GEEKJOB_db?characterEncoding=UTF-8&serverTimezone=JST","KENHANAOKA","kamehameha99");
            System.out.print("Connectioned");
            return db_con;
        }
        
        catch(ClassNotFoundException e){
            throw new IllegalMonitorStateException();
        }
        
        catch (SQLException e) {
            throw new IllegalMonitorStateException();
        }
    }
}