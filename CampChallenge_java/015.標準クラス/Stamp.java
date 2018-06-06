package org.camp.Process;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author Ken Hanaoka
 */
public class Stamp {
    //処理を開始する日時をファイルに記録する//
    void logStart() {
        try {
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            File fp = new File("logfile.txt");
            FileWriter fw = new FileWriter(fp);
            fw.write("モンテカルロ法による計算(Mathクラス使用)\r\n");
            fw.write("処理を開始しました " + sdf.format(now) + "\r\n");
            fw.close();
        }
        
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    //処理を終了した日時をファイルに記録する//
    void logEnd() {
        try {
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            File fp = new File("logfile.txt");
            FileWriter fw = new FileWriter(fp,true);
            fw.write("処理を終了しました" + sdf.format(now) + "\r\n");
            fw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
}
