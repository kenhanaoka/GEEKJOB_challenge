package org.camp.servlet;

// 1. JavaBeansのルール{java.io.Serializableインターフェイスの実装} //
import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Ken Hanaoka
 */
public class ResultData implements Serializable {
    // 2. JavaBeansのルール{フィールドはカプセル化(外部クラスやメソッドからのアクセス遮断)する} //
    private Date d;
    private String luck;
    // 3. JavaBeansのルール{publicで引数のないコンストラクタを持つ} //
    public ResultData() {}
    // 4. JavaBeansのルール{フィールドは，publicで命名規則に沿ったgetter，setterを持つ} //
    //ゲッター//
    public Date getD() {
        return d;
    }
    //セッター//
    public void setD(Date d) {
        this.d = d;
    }
       
    public String getLuck() {
        return luck;
    }
    
    public void setLuck(String luck) {
        this.luck = luck;
    }
}
