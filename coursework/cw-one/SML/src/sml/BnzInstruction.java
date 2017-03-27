package sml;

/**
 * Class representing an Instruction of type Bnz (an instruction that jumps to a
 * given label to execute that line)
 *
 * @author Pablo Quinoa
 */
public class BnzInstruction extends Instruction {

    /**
     * Operand 1 (is really the register where we store this operand)
     */
    private int op1;

    /**
     * The label we want to jump to
     */
    private String label2;

    /**
     * Constructs a new Instruction of type Bnz based on the parameters.
     *
     * @param label the instruction label
     * @param op the instruction opcode
     */
    public BnzInstruction(String label, String op) {
        super(label, op);
    }

    /**
     * Constructs a new Instruction of type Bnz based on the parameters.
     *
     * @param label the instruction label
     * @param op1 Operand 1
     * @param label2 the label we want to jump to
     */
    public BnzInstruction(String label, int op1, String label2) {
        this(label, "bnz");
        this.op1 = op1;
        this.label2 = label2;
    }

    /**
     * Method that overrides execute from Instruction. It reads an operand from
     * the machine registers and if this one is different from 0, adds the
     * instruction referenced by label2 to the program arrayList to be executed
     * next.
     *
     * @param m the machine language interpreter
     */
    @Override
    public void execute(Machine m) {
        int value1 = m.getRegisters().getRegister(op1);
        if (value1 != 0) {
            int indexLabel2 = m.getLabels().indexOf(label2);
            m.getProg().add(m.getPc(), m.getProg().get(indexLabel2));
        }
    }

    /**
     * Returns the representation of the bnz instruction
     *
     * @return the representation of this Instruction
     */
    @Override
    public String toString() {
        return super.toString() + " " + op1 + " jump to " + label2;
    }

}
