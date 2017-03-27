package sml;

/**
 * Abstract class representing an Instruction
 *
 * @author Pablo Quinoa
 */
public abstract class Instruction {

    /**
     * The label for the line (reference to the line containing an instruction)
     */
    protected String label;

    /**
     * The instruction opcode (can be 'add','sub','mul'..)
     */
    protected String opcode;

    /**
     * Constructs a new Instruction based on the parameters.
     *
     * @param l the instruction label
     * @param op the instruction opcode
     */
    public Instruction(String l, String op) {
        this.label = l;
        this.opcode = op;
    }

    /**
     * Returns the representation "label: opcode" of this Instruction
     *
     * @return the representation of this Instruction
     */
    @Override
    public String toString() {
        return label + ": " + opcode;
    }

    /**
     * Abstract method that executes Instruction on machine m (perform
     * arithmetic operation) to be implemented in subclasses
     *
     * @param m the machine language interpreter
     */
    public abstract void execute(Machine m);
}
