package sml;

/**
 * Class representing the machine registers and has methods to access them aswell
 * as change their contents.
 *
 * @author Pablo Quinoa
 */
public class Registers {

    private final static int NUMBEROFREGISTERS = 32;
    
    /**
     * An array of integers that represents the machine registers
     */
    private int registers[];

    {
        registers = new int[NUMBEROFREGISTERS];
    }

    /**
     * Constructs a new Registers, an instance whose registers are set to 0
     */
    public Registers() {
        for (int i = 0; i != registers.length; i++) {
            registers[i] = 0;
        }
    }

    // Set register i to v.
    // Precondition: 0 <= i <= NUMBEROFREGISTERS

    /**
     * Setter method that sets register i, with v value.
     *
     * @param i the register index (reference)
     * @param v the value to be stored in the given register
     */
    public void setRegister(int i, int v) {
        registers[i] = v;
    }

    /**
     * Returns the content of a given register given the index
     *
     * @param i the register index (reference)
     * 
     * @return content of the register
     */
    public int getRegister(int i) {
        return registers[i];
    }

    /**
     * Returns the registers array
     * 
     * @return the registers
     */
    public int[] getRegisters() {
        return this.registers;
    }

    /**
     * Setter method that sets an array registers
     *
     * @param registers the array registers
     */
    public void setRegisters(int[] registers) {
        this.registers = registers;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Registers)) return false;
        final Registers other = (Registers) o;
        if (!other.canEqual((Object) this)) return false;
        if (!java.util.Arrays.equals(this.registers, other.registers)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + java.util.Arrays.hashCode(this.registers);
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Registers;
    }

    @Override
    public String toString() {
        return "sml.Registers(registers=" + java.util.Arrays.toString(this.registers) + ")";
    }
}