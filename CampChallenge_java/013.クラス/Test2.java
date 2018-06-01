
package org.camp.Mydata;

/**
 *
 * @author Ken Hanaoka
 */
public class Test2 {
    public static void main(String[] args) {
        FieldClear2 fc = new FieldClear2();
        
        fc.set("aqua", 40);
        fc.print();
        
        fc.clear();
        fc.print();
    }
    
}

