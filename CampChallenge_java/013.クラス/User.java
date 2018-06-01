package org.camp.BlackJack;

import java.util.ArrayList;
/**
 *
 * @author Ken Hanaoka
 */

class User extends Human {
    
    
     
   //手札の合計を計算する処理（11～13は10に換算する．1は11に換算し，手札の合計が21を超えたら1と換算）//
    @Override
    public int open() {
        int total = 0;
        for (int i = 0; i < myCard.size();i++) {
            if(myCard.get(i) > 10) {
                total += 10;
            }
            else if (myCard.get(i) == 1 && total < 11) {
                total += 11;
            }
            else {
                total += myCard.get(i);
            }
        }

        if (total > 21) {
            for (int i = 0; i < myCard.size();i++) {
                if (myCard.get(i) == 1 && total > 21) {
                    total -= 10;
                }
            }
        }
        
        return total;
    }
    
    //引いたカードを手札に加える処理//
    @Override
    public void setCard(ArrayList<Integer> cardList) {
        myCard.addAll(cardList);
    }
    
    //もう一度引くかどうか決める処理//
    @Override
    public boolean checkSum() {
        
        if (open() < 16) {
            return true;
        }
        
        return false;
    }
    
}
