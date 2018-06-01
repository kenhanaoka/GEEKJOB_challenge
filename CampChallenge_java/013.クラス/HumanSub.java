package org.camp.Mydata;

class SelfDataSub extends SelfData {
    void dataClear () {
        //SelfDataクラスを継承し，継承したクラスのフィールド変数をクリアする//
        SelfData data = new SelfData();
        data.dataAdd(0, 0);
    }

} 

public class HumanSub {
    
    public static void main(String[] arg) {
        //インスタンスを取り出し，実行する//
        SelfDataSub data = new SelfDataSub();
        data.dataClear();
        data.display();
        
    }
    
}
