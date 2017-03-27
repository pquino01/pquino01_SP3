package implementation

import bc.{ByteCode, ByteCodeValues}
import vm.VirtualMachine

/**
  * This class represents the bytecote implementation of an Imul
  *
  * @author Ullash Hazarika, Pablo Quinoa
  */
class Imul extends ByteCode {
  /**
    * A unique byte value representing the bytecode. It sets this to the bytecode
    * corresponding to the name of the bytecode in [[ByteCodeValues]]
    */
  override val code: Byte = bytecode("imul")

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    val value1= vm.pop()
    val value2= vm.pop()
    vm.push(value1._1 * value2._1)
  }
}
