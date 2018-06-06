package org.camp.Process;

import java.lang.Math;
import java.io.*;
/**
 *
 * @author Ken Hanaoka
 */
class Calculate {
    double n = 10000000.0;  //試行回数
    double x = 0.0;         //座標
    double y = 0.0;         //座標
    double sFan = 0.0;      //扇内に発生した確率

    //モンテカルロ法による円周率の計算(Mathクラスを使用)//
    //半径1の円を四等分した扇の面積と辺1の正方形の面積の比から円周率を計算//
    public double monteCarlo() {
        //発生した乱数の座標が扇内であるとき，その回数をカウントする//
        for (double i = 0; i < n; i++ ) {
            x = Math.random();
            y = Math.random();
            if(Math.sqrt(x*x + y*y) <= 1.0) {
                sFan += 1.0;
            }
        }
        double pi = 4*sFan/n; //円周率
        return pi;
    }
}
