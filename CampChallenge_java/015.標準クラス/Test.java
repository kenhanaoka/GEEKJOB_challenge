package org.camp.Process;

/**
 *
 * @author Ken Hanaoka
 */
public class Test {
    public static void main(String[] args) {
        //処理を実行，処理前後にログをとる//
        Stamp st = new Stamp();
        Calculate cal = new Calculate();
        
        st.logStart();
        System.out.print(cal.monteCarlo());
        st.logEnd();
    }
    
}
