package sml;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
public class Translator {

    private static final String PATH = "C:/Users/pablo/Documents/NetBeansProjects/pquino01_SP3/coursework/cw-one/SML/";
    // word + line is the part of the current line that's not yet processed
    // word has no whitespace
    // If word and line are not empty, line begins with whitespace
    private String line = "";
    private Labels labels; // The labels of the program being translated
    private ArrayList<Instruction> program; // The program to be created
    private String fileName; // source file of SML code

    public Translator(String fileName) {
        this.fileName = PATH + fileName;
    }

    // translate the small program in the file into lab (the labels) and
    // prog (the program)
    // return "no errors were detected"
    public boolean readAndTranslate(Labels lab, ArrayList<Instruction> prog) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        try (Scanner sc = new Scanner(new File(fileName))) {
            // Scanner attached to the file chosen by the user
            labels = lab;
            labels.reset();
            program = prog;
            program.clear();

            try {
                line = sc.nextLine();
            } catch (NoSuchElementException ioE) {
                return false;
            }

            // Each iteration processes line and reads the next line into line
            while (line != null) {
                // Store the label in label
                String label = scan();

                if (label.length() > 0) {
                    Instruction ins = getInstruction(label);
                    if (ins != null) {
                        labels.addLabel(label);
                        program.add(ins);
                    }
                }

                try {
                    line = sc.nextLine();
                } catch (NoSuchElementException ioE) {
                    return false;
                }
            }
        } catch (IOException ioE) {
            System.out.println("File: IO error " + ioE.getMessage());
            System.exit(-1);
            return false;
        }
        return true;
    }

    // line should consist of an MML instruction, with its label already
    // removed. Translate line into an instruction with label label
    // and return the instruction
    public Instruction getInstruction(String label) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int s1; // Possible operands of the instruction
        int s2;
        int r;
        String label2;
        if (line.equals("")) {
            return null;
        }
        String ins = scan();
        // capitalize the first letter of a string named ins and leave the rest alone
        String instructionName = ins.substring(0, 1).toUpperCase() + ins.substring(1);
        instructionName=instructionName.concat("Instruction");
        String instructionNameClass="sml."+instructionName;
        Class cls = Class.forName(instructionNameClass);
        Constructor constructor;
        Instruction instruction;
        switch (ins) {
            case "out":
                Object[] argumentsOut = new Object[2];
                s1 = scanInt();
                argumentsOut[0]= label;
                argumentsOut[1]=s1;
                constructor = (Constructor) cls.getConstructor(new Class[]{String.class,int.class});
                instruction = (Instruction) constructor.newInstance(argumentsOut);
                return instruction;
            case "lin":
                Object[] argumentsLin = new Object[3];
                r = scanInt();
                s1 = scanInt();
                argumentsLin[0]= label;
                argumentsLin[1]=r;
                argumentsLin[2]=s1;
                constructor = (Constructor) cls.getConstructor(new Class[]{String.class,int.class,int.class});
                instruction = (Instruction) constructor.newInstance(argumentsLin);
                return instruction;
            case "bnz":
                Object[] argumentsBnz = new Object[3];
                s1 = scanInt();
                label2 = scan();
                argumentsBnz[0]= label;
                argumentsBnz[1]=s1;
                argumentsBnz[2]=label2;
                constructor = (Constructor) cls.getConstructor(new Class[]{String.class,int.class,String.class});
                instruction = (Instruction) constructor.newInstance(argumentsBnz);
                return instruction;
            default: //this default piece of program would work for any new arithmetic instruction we create in the future (e.g. ExpInstruction..)
                Object[] arguments = new Object[4];
                r = scanInt();
                s1 = scanInt();
                s2 = scanInt();
                arguments[0]= label;
                arguments[1]=r;
                arguments[2]=s1;
                arguments[3]=s2;
                constructor = (Constructor) cls.getConstructor(new Class[]{String.class,int.class,int.class,int.class});
                instruction = (Instruction) constructor.newInstance(arguments);
                return instruction;
        }
           
    }

    /*
     * Return the first word of line and remove it from line. If there is no
     * word, return ""
     */
    private String scan() {
        line = line.trim();
        if (line.length() == 0) {   
            return "";
        }

        int i = 0;
        while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '\t') {
            i = i + 1;
        }
        String word = line.substring(0, i);
        line = line.substring(i);
        return word;
    }

    // Return the first word of line as an integer. If there is
    // any error, return the maximum int
    private int scanInt() {
        String word = scan();
        if (word.length() == 0) {
            return Integer.MAX_VALUE;
        }

        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException e) {
            return Integer.MAX_VALUE;
        }
    }

}
