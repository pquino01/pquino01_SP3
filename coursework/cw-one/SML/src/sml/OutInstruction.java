package sml;

/**
 * Class representing an Instruction of type out (print)
 *
 * @author Pablo Quinoa
 */
public class OutInstruction extends Instruction {

    /**
     * The register we want to print its content
     */
    private int op1;

    /**
     * Constructs a new Instruction of type Out based on the parameters.
     *
     * @param label the instruction label
     * @param op the instruction opcode
     */
    public OutInstruction(String label, String op) {
        super(label, op);
    }

    /**
     * Constructs a new Instruction of type Out based on the parameters.
     *
     * @param label the instruction label
     * @param op1 register to be printed
     */
    public OutInstruction(String label, int op1) {
        this(label, "out");
        this.op1 = op1;
    }

    /**
     * Method that overrides execute from Instruction. It reads the given
     * register from the machine registers and print out in the console its
     * stored value
     *
     * @param m the machine language interpreter
     */
    @Override
    public void execute(Machine m) {
        int value1 = m.getRegisters().getRegister(op1);
        System.out.println(value1);
    }

    /**
     * Returns the representation of the Out instruction
     *
     * @return the representation of this Instruction
     */
    @Override
    public String toString() {
        return super.toString() + " " + op1;
    }

}
