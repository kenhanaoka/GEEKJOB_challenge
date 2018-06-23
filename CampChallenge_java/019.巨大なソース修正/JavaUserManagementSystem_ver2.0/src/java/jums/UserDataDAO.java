package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            //修正：ユーザーIDを追加//
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(userID,name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?,?)");
            st.setInt(1, ud.getUserID());
            st.setString(2, ud.getName());
            st.setDate(3, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(4, ud.getTell());
            st.setInt(5, ud.getType());
            st.setString(6, ud.getComment());
            st.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    
    //修正：検索をArrayListに格納する
    public ArrayList<UserDataDTO> search(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
    //名前，誕生月，職業条件検索，条件指定がなければ全件検索        
            String sql = "SELECT * FROM user_t";
            boolean flag = false;
            if (!ud.getName().equals("")) {
                sql += " WHERE name like ?";
                flag = true;
            }
            if (ud.getBirthday() != null) {
                if(!flag){
                    sql += " WHERE birthday like ?";
                    flag = true;
                }else{
                    sql += " AND birthday like ?";
                }
            }
            if (ud.getType() != 0) {
                if(!flag){
                    sql += " WHERE type like ?";
                }else{
                    sql += " AND type like ?";
                }
            }
            st =  con.prepareStatement(sql);
            
            //検索条件により場合分け
            if(!ud.getName().equals("")) {
                st.setString(1, "%"+ud.getName()+"%");
                
                if (ud.getBirthday() != null) {
                    st.setString(2, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                    
                    if (ud.getType() != 0) {
                        st.setInt(3, ud.getType());
                    }
                }
                else {
                    if (ud.getType() != 0) {
                        st.setInt(2, ud.getType());
                    }
                }
            }
            else {
                if (ud.getBirthday() != null) {
                    st.setString(1, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                    
                if (ud.getType() != 0) {
                        st.setInt(2, ud.getType());
                    }
                }
                else {
                    if (ud.getType() != 0) {
                        st.setInt(1, ud.getType());
                    }
                }
            
            }
            
            
            ResultSet rs = st.executeQuery();
            ArrayList<UserDataDTO> resultUd= new ArrayList<UserDataDTO>();
            while(rs.next()) {
                UserDataDTO result = new UserDataDTO();
                result.setUserID(rs.getInt(1));
                result.setName(rs.getString(2));
                result.setBirthday(rs.getDate(3));
                result.setTell(rs.getString(4));
                result.setType(rs.getInt(5));
                result.setComment(rs.getString(6));
                result.setNewDate(rs.getTimestamp(7));
                resultUd.add(result);
            }
            System.out.println("search completed");

                return resultUd;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            
            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    //追加：テーブルの一番下のレコードのuserIDに1足した値を求め，userIDにセットする//
    public UserDataDTO CountUserID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            con = DBManager.getConnection();
            
            st =  con.prepareStatement("SELECT COUNT(*) AS num from user_t");
             
            rs = st.executeQuery();
            rs.next();
            int lastNum = rs.getInt("num")-1;
            
            st =  con.prepareStatement("SELECT userID FROM user_t LIMIT ? , 1 ");
            st.setInt(1, lastNum);
            rs = st.executeQuery();
            rs.next();
            ud.setUserID(rs.getInt("userID")+1);
            return ud;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                
                con.close();
            }
        }

    }
    
    public UserDataDTO update(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "update user_t set name=?,birthday=?,tell=?,type=?,comment=?,newDate=? where userID=?";
            
            st = con.prepareStatement(sql);
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));
            st.setInt(7, ud.getUserID());
            st.executeUpdate();
            
            System.out.println("Update completed");
            return ud;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    //追加：指定されたIDのレコードを削除する
    public void delete(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "delete from user_t where userID=?";
            
            st = con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            st.executeUpdate();
            
            System.out.println("Delete completed");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }

}
