
package org.camp.Mydata;

/**
 *
 * @author Ken Hanaoka
 */
public class Car2 {
    public String name = "";
    public int velocity = 0;
    
   public void set(String name,int velocity) {
        this.name = name;
        this.velocity = velocity;
    }
    
   public void print() {
       System.out.println(this.name);
       System.out.println(this.velocity);
   }
}

