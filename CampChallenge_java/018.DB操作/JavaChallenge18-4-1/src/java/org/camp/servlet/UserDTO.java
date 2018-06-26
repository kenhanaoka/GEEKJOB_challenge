package org.camp.servlet;
import java.io.Serializable;

/**
 *
 * @author Ken Hanaoka
 */
public class UserDTO implements Serializable{
/**
 * ユーザー情報を持ちまわるJavaBeans
 データベースのカラムと型に対応させている(UserDTO)。データの挿入、取り出しどちらにも便利
 */

    private String password;
    private String name;
    private String productName;
    private int productPrice;
    private String productType;
    private String submit;
    
    public UserDTO() {
        password = "";
        name = "";
        productName = "";
        productPrice = 0;
        productType = "";
        submit = "";
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        if(!password.equals("")) {
            this.password = password;
        }
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        if(!name.equals("")) {
            this.name = name;
        }
    }
    
    public String getProductName(){
        return this.productName;
    }
    public void setProductName(String productName){
        if(!productName.equals("")) {
            this.productName = productName;
        }
    }
    
    public int getProductPrice() {
        return this.productPrice;
    }
    public void setProductPrice(int productPrice) {
        if(productPrice != 0) {
            this.productPrice = productPrice;
        }
    }
    
    public String getProductType(){
        return this.productType;
    }
    public void setProductType(String productType){
        if(!productType.equals("")) {
            this.productType = productType;
        }
    }
    
    public String getSubmit(){
        return this.submit;
    }
    
    public void setSubmit(String submit){
        if(!submit.equals("")) {
            this.submit = submit;
        }
    }
}