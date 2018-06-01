
package org.camp.Mydata;

/**
 *
 * @author Ken Hanaoka
 */
public class Car {
    String name;
    int velocity;
    
    void assign(String name,int velocity) {
        this.name = name;
        this.velocity = velocity;
    }
    
   void print() {
       System.out.println(this.name);
       System.out.println(this.velocity);
   }
}

