package sml;

/**
 * Class representing an Instruction of type addition
 *
 * @author Pablo Quinoa
 */
public class AddInstruction extends Instruction {

    /**
     * The result from adding the two operands (is really the register where we store this result)
     */
    private int result;

    /**
     * Operand 1 of the addition (is really the register where we store this operand)
     */
    private int op1;

    /**
     * Operand 2 of the addition (is really the register where we store this operand)
     */
    private int op2;

    /**
     * Constructs a new Instruction of type Addition based on the parameters.
     *
     * @param label the instruction label
     * @param op the instruction opcode
     */
    public AddInstruction(String label, String op) {
        super(label, op);
    }

    /**
     * Constructs a new Instruction of type Addition based on the parameters.
     *
     * @param label the instruction label
     * @param result the instruction result
     * @param op1 Operand 1 of the addition
     * @param op2 Operand 2 of the addition
     */
    public AddInstruction(String label, int result, int op1, int op2) {
        this(label, "add");
        this.result = result;
        this.op1 = op1;
        this.op2 = op2;
    }

    /**
     * Method that overrides execute from Instruction. It reads both operands
     * from the machine registers and writes in a register the result (the
     * addition of the two operands)
     *
     * @param m the machine language interpreter
     */
    @Override
    public void execute(Machine m) {
        int value1 = m.getRegisters().getRegister(op1);
        int value2 = m.getRegisters().getRegister(op2);
        m.getRegisters().setRegister(result, value1 + value2);
    }

    /**
     * Returns the representation of the addition instruction
     *
     * @return the representation of this Instruction
     */
    @Override
    public String toString() {
        return super.toString() + " " + op1 + " + " + op2 + " to " + result;
    }
}
