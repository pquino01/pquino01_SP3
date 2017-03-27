package implementation

import bc.{ByteCode, ByteCodeValues}
import vm.VirtualMachine

/**
  * This class represents the bytecote implementation of an Iconst.
  *
  * @constructor Creates a new Iconst with a 'num'
  * @param num the integer to be loaded into the virtual machine stack
  *
  * @author Ullash Hazarika, Pablo Quinoa
  */
class Iconst (num : Int) extends ByteCode  {

  /**
    * A unique byte value representing the bytecode. It sets this to the bytecode
    * corresponding to the name of the bytecode in [[ByteCodeValues]]
    */
  override val code: Byte = bytecode("iconst")

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    vm.push(num)
  }
}


