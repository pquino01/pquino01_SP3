package sml;

/**
 *
 * @author pablo
 */
public class BnzInstruction extends Instruction{
    private int op1;
    private String label2;

    public BnzInstruction(String label, String op) {
        super(label, op);
    }
    
    public BnzInstruction(String label, int op1, String label2) {
        this(label, "bnz");
        this.op1 = op1;
        this.label2 = label2;
    }

    @Override
    public void execute(Machine m) {
        int value1 = m.getRegisters().getRegister(op1);
        if (value1!=0){
           int indexLabel2= m.getLabels().indexOf(label2);
           m.getProg().add(m.getPc(), m.getProg().get(indexLabel2));
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + " " + op1 + " jump to " + label2;
    }
    
}
