package worksheet02_4;

/**
 *
 * @author pablo
 */
public class SimpleClassToTest {
    
    private String string1;
    private String string2;
    private int num;
    private AnotherClass anotherClass;
    
    public SimpleClassToTest(String string1, String string2, int num, AnotherClass anotherClass) {
        this.string1=string1;
        this.string2=string2;
        this.num=num;
        this.anotherClass=anotherClass;
    }

    public SimpleClassToTest(String string1) {
        this.string1 = string1;
        System.out.println(string1);
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
