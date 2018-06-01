/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.BlackJack;
import java.util.ArrayList;

/**
 *
 * @author Ken Hanaoka
 */
abstract public class Human1 {
    //手持ちのカードを格納する配列初期化//
    ArrayList<Integer> myCard = new ArrayList<>();
    //手札の合計値を計算する，引いたカードを手札に加える，追加してカードを引くか判別する//
    abstract public int open();
    abstract public void setCard(ArrayList<Integer> cardList);
    abstract public boolean checkSum();
    
}
