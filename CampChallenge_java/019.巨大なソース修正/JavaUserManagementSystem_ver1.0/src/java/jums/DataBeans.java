package jums;

/**
 *
 * @author Ken Hanaoka
 */
//課題3.//
import java.io.Serializable;


public class DataBeans implements Serializable {
    private String name;
    private int year;
    private int month;
    private int day;
    private int type;
    private String tell;
    private String comment;
    private static DataBeans db = new DataBeans();
    
    public DataBeans(){}
    
    public static DataBeans getInstance(){
        return db;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public int getYear() {
        return this.year;
    }

    public void setMonth(int month) {
        this.month = month;
    }
    public int getMonth() {
        return this.month;
    }

    public void setDay(int day) {
    this.day = day;
}
public int getDay() {
    return this.day;
}

    public void setType(int type) {
        this.type = type;
    }
    public int getType() {
        return this.type;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }
    public String getTell() {
        return this.tell;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getComment() {
        return this.comment;
    }
}
