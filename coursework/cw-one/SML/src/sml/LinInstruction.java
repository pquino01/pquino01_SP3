package sml;

/**
 * Class representing an Instruction of type lin
 *
 * @author Pablo Quinoa
 */
public class LinInstruction extends Instruction {

    /**
     * The register from the machine where we want to store a certain integer
     */
    private int register;

    /**
     * The integer we want to store in a register from the machine (is really the register where we store this value)
     */
    private int value;

    /**
     * Constructs a new Instruction of type Lin based on the parameters.
     *
     * @param label the instruction label
     * @param opcode the instruction opcode
     */
    public LinInstruction(String label, String opcode) {
        super(label, opcode);
    }

    /**
     * Constructs a new Instruction of type Lin based on the parameters.
     *
     * @param label the instruction label
     * @param register the register where we will store value
     * @param value the integer to store in the machine register
     */
    public LinInstruction(String label, int register, int value) {
        super(label, "lin");
        this.register = register;
        this.value = value;

    }

    /**
     * Method that overrides execute from Instruction. It writes on the machine
     * registers the value given.
     *
     * @param m the machine language interpreter
     */
    @Override
    public void execute(Machine m) {
        m.getRegisters().setRegister(register, value);
    }

    /**
     * Returns the representation of the lin instruction
     *
     * @return the representation of this Instruction
     */
    @Override
    public String toString() {
        return super.toString() + " register " + register + " value is " + value;
    }
}
