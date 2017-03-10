package worksheet02_1;

import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class Worksheet02_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String className;
        ClassInterface cI;
        do {
            System.out.println("Write the full name of a class (including package name): ");
            //e.g. "java.lang.Math" or "worksheet02_1.ClassInterface"
            className = scan.nextLine();
            cI = new ClassInterface(className);
            cI.printClass();
        } while (!cI.getValidClassName());

    }

}
