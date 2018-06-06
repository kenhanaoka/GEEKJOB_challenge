package org.camp.Files;

import java.io.*;

/**
 *
 * @author Ken Hanaoka
 */
public class ReadFile {
    public static void main(String[] args) {
        //テキストファイルを読み出し画面に表示する//
        File fp = new File("Sample.txt");
        try {
            
            FileReader fr = new FileReader(fp);
            BufferedReader br = new BufferedReader(fr);
            System.out.print(br.readLine());
            br.close();            
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
