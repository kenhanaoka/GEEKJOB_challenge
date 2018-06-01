package org.camp.BlackJack;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Ken Hanaoka
 */

public class BlackJack {
    public static void main(String[] arg) {
        Dealer d = new Dealer();
        User u = new User();
        
        
        //ユーザーとディーラーの手札に2枚加える//
        u.setCard(d.deal());
        d.setCard(d.deal());
        System.out.println("User   : " + u.myCard);
        System.out.println("Dealer : " + d.myCard);
        
        //ユーザーの初手が21のときの処理(ナチュラル21)//
        if(u.open() == 21) {
            if(d.open() == 21) {
                System.out.println("User   : Draw");
                System.exit(0);
            }
            else {
                System.out.println("User   : Natural21");
                System.out.println("User   : Win");
                System.exit(0);
                
            }
        }
        
        
        //ユーザーがカードを追加し，21を超えたらその時点でゲーム終了（バスト）//
        while (u.checkSum()) {
        u.myCard.addAll(d.hit());
        System.out.println("User   : Hit " );
        System.out.println("User   : " + u.myCard);
        }
        if (u.open() > 21) {
            System.out.println("User   : " + String.valueOf(u.open()));
            System.out.println("User   : Bust");
            System.out.println("User   : Loose");
            System.exit(0);
        }
        else {
            System.out.println("User   : Stand");
        }
        
        //ディーラーがカードを追加し，勝敗をが決まる//
        while (d.checkSum()) {
        d.myCard.addAll(d.hit());
        System.out.println("Dealer : Hit ");
        System.out.println("Dealer : " + d.myCard);
        }
        System.out.println("Dealer : Open");
        System.out.println("User : " + u.myCard + " " + (u.open()) + "pt");
        System.out.println("Dealer : " + d.myCard + " " + (d.open()) + "pt");
        
        if(u.open() < d.open() && d.open() < 22) {
            System.out.println("User   : Loose");
        } 
        else if(d.open() == u.open()){
            System.out.println("User   : Draw");
        }
        else {
            System.out.println("User   : Win");
        }
    }
    
}
