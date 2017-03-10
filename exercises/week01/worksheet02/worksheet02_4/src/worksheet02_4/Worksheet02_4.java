package worksheet02_4;

import java.lang.reflect.Field;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class Worksheet02_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

        AnotherClass otherObj = new AnotherClass("Pablo");
        SimpleClassToTest obj = new SimpleClassToTest("hello", "world", 1, otherObj);
        System.out.println(toStringGeneral(obj));
    }

    public static String toStringGeneral(Object obj) throws IllegalArgumentException, IllegalAccessException {
        String toStringGeneral = "";
        Class cls = obj.getClass();
        String className = cls.getName();
        toStringGeneral += className.substring(className.lastIndexOf('.') + 1);
        toStringGeneral += "{";
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object fieldValue = field.get(obj);
            toStringGeneral += field.getName() + " ";
            toStringGeneral += fieldValue;
            toStringGeneral += ",";
        }
        toStringGeneral += "}";
        return toStringGeneral;
    }

}
