package org.camp.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ken Hanaoka
 */
public class UserDAO {
    //フォームで入力されたユーザー名，パスワードと合致するレコードを検索し，あればtrue，なければfalseを返す//
    public boolean judgment(UserDTO dto) throws SQLException{
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        try {
            if (!dto.getName().equals("") || !dto.getPassword().equals("")) {
                db_con = DBconnection.getConnection();
                db_st = db_con.prepareStatement("SELECT * FROM userInfo WHERE name = ? AND password = ?");
                db_st.setString(1, dto.getName());
                db_st.setString(2, dto.getPassword());
                db_data = db_st.executeQuery();
                if(db_data.next()) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        
        catch (Exception e) {
            return false;
        }
        
        finally {
            if (db_con != null) {
                db_con.close();
            }
            if (db_st != null) {
                db_st.close();
            }
            if (db_data != null) {
                db_data.close();
            }
        }
    }
    
    //ユーザー名，パスワードを登録する//
    public void userInsert(UserDTO dto) throws SQLException{
        Connection db_con = null;
        PreparedStatement db_st = null;
        
        try {
            db_con = DBconnection.getConnection();
            db_st = db_con.prepareStatement("insert into userInfo values (?,?)");
            db_st.setString(1, dto.getName());
            db_st.setString(2, dto.getPassword());
            db_st.executeUpdate();
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        finally {
            if (db_con != null) {
                db_con.close();
            }
            if (db_st != null) {
                db_st.close();
            }
        }
    }
    //商品名，価格，種別を登録する//
    public void productInsert(UserDTO dto) throws SQLException{
        Connection db_con = null;
        PreparedStatement db_st = null;
        
        try {
            db_con = DBconnection.getConnection();
            db_st = db_con.prepareStatement("insert into products values (?,?,?)");
            db_st.setString(1, dto.getProductName());
            db_st.setInt(2, dto.getProductPrice());
            db_st.setString(3, dto.getProductType());
            db_st.executeUpdate();
        }
    
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    
        finally {
            if (db_con != null) {
                db_con.close();
            }
            if (db_st != null) {
                db_st.close();
            }
        }
    }
    public String checkList(UserDTO dto) {
        String chk = "";
        if(dto.getProductName().equals("")) {
            chk += "商品名";
        }
        if(dto.getProductPrice() == 0) {
            chk += "価格";
        }
        if(dto.getProductType().equals("")) {
            chk += "種別";
        }
        return chk;
    }
    
    //商品を全件検索して，商品リストを返す
    public ArrayList<UserDTO> productsList() throws SQLException{
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        ArrayList<UserDTO> list = new ArrayList<UserDTO>();
        
        try {
            db_con = DBconnection.getConnection();
            db_st = db_con.prepareStatement("SELECT * FROM products");
            db_data = db_st.executeQuery();
            
            while (db_data.next()) {
                UserDTO dto = new UserDTO();
                dto.setProductName(db_data.getString(1));
                dto.setProductPrice(db_data.getInt(2));
                dto.setProductType(db_data.getString(3));
                list.add(dto);
            }
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    
        finally {
            if (db_con != null) {
                db_con.close();
            }
            if (db_st != null) {
                db_st.close();
            }
        }
        
        return list;
        
    }

}