package worksheet02_2;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class Worksheet02_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String className;

        System.out.println("Write the full name of a class (including package name): ");
        //e.g. "worksheet02_2.simpleClassToTest" 
        className = scan.nextLine();
        System.out.println("Write the total number of attributes ");
        int numArguments = scan.nextInt();
        Object[] arguments = new Object[numArguments];
        Class[] parameterTypes= new Class[numArguments];
        int i = 0;
        scan.nextLine();
        while (i<numArguments) {
            System.out.println("Write an argument(String): ");
            arguments[i] = scan.nextLine();
            parameterTypes[i] = String.class;
            i++;
        };
        try {
            Class cl = Class.forName(className);
            Object obj;
            obj = cl.getConstructor(parameterTypes).newInstance(arguments);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Worksheet02_2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
