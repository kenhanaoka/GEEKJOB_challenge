package org.camp.Mydata;

class SelfData {
    //フィールド変数2つ（年齢，身長）//
    public int age;
    public int height;
    
    //年齢，身長をセット//
    public void dataAdd(int age,int height) {
        this.age = age;
        this.height = height;
    }
    
    //データを表示する//
    public void display() {    
        
        System.out.println(String.valueOf(age));
        System.out.println(String.valueOf(height));
        
    }
}

public class Human {
    
        
    public static void main (String[] arg) {
        SelfData data = new SelfData();
        data.dataAdd(23,170);
        data.display();
        
    }
    
}
