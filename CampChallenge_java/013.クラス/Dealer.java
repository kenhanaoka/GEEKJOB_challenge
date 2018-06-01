package org.camp.BlackJack;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Ken Hanaoka
 */

class Dealer extends Human {
     ArrayList<Integer> cards = new ArrayList<>();
    
    
        //52枚（1～13のカード4枚ずつ）を山札に配置する処理//
    Dealer() {
        for (int i = 1; i < 14; i++) {
            for (int j = 1; j < 5; j++) {
                cards.add(i);
            }       
        }
    }
    
    
    //ランダムに山札から2枚のカードを選ぶ処理//
    ArrayList<Integer> deal() {
        ArrayList<Integer> dealCards = new ArrayList<>();
        Random rand = new Random();
        
        for (int i = 0; i < 2; i++) {
            int shuffleNum = rand.nextInt(cards.size());
            dealCards.add(cards.get(shuffleNum));
            cards.remove(shuffleNum);
        }
        return dealCards;
    }
    
   //ランダムに山札からカードを1枚選ぶ処理//
    ArrayList<Integer> hit() {
        ArrayList<Integer> hitCard = new ArrayList<>();
        Random rand = new Random();
        int shuffleNum = rand.nextInt(cards.size());
        hitCard.add(cards.get(shuffleNum)); 
        cards.remove(shuffleNum);
        return hitCard;
    }
    
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
    public void setCard(ArrayList<Integer> setCard) {
        myCard.addAll(setCard);
    }
    
    //もう一度引くかどうか決める処理//
    @Override
    public boolean checkSum() {
        if (open() < 18) {
            return true;
        }
        return false;
    }
    
}
