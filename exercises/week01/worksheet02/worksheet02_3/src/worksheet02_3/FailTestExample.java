package worksheet02_3;

import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class FailTestExample {
    
    private String string1;
    private String string2;
    private String string3;
    private String string4;
    private String string5;
    public String string6;
    private ArrayList<String> list = new ArrayList<String>();

    
    
    public FailTestExample(String string1, String string2) {
        this.string1=string1;
        this.string2=string2;
        System.out.println(string1+" "+string2);
    }

    public FailTestExample(String string1) {
        this.string1 = string1;
        System.out.println(string1);
    }
    
    private void aux() throws Exception{}
    
    private void aux2(){}
    
    public int returnInteger(){
        int num=5;
        return num;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }
    
}
