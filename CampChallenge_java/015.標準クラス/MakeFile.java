package org.camp.Files;
import java.io.*;

/**
 *
 * @author Ken Hanaoka
 */

public class MakeFile {
    public static void main(String[] args) {
        //テキストファイルを作製し，自分の名前を書き込む//
        File fp = new File("logfile.txt");
        try {
            fp.createNewFile();
            FileWriter fw = new FileWriter(fp);
            
            fw.write("私の名前は花岡憲です");
            fw.close();            
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}
