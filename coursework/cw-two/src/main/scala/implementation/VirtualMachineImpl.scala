package implementation

import bc.ByteCode
import vm.VirtualMachine

import scala.collection.mutable.ListBuffer

/**
  * Created by pablo on 20/03/2017.
  */
class VirtualMachineImpl extends VirtualMachine {

  var stack= new ListBuffer[Int]

  /**
    * Executes a vector of bytecodes.
    *
    * Note, that this is an "immutable" object. That is, it
    * will return a new virtual machine after executing each
    * of the bytecode objects in the vector.
    *
    * @param bc a vector of bytecodes
    * @return a new virtual machine
    */
  override def execute(bc: Vector[ByteCode]): VirtualMachine = {
    val vm = new VirtualMachineImpl()
    var newVm= bc.head.execute(vm)
    val listBc=bc.to[ListBuffer]
    var i=1
    while (i<listBc.length){
      newVm= listBc(i).execute(newVm)
      i+=1
    }
    newVm
  }

  /**
    * Executes the next bytecode in the vector of bytecodes.
    *
    * This method only executes a single byte code in the vector of bytecodes.
    * It returns a tuple of the new vector of bytecodes (with the executed
    * bytecode removed) and the new virtual machine.
    *
    * You may assume that `bc` contains at least 1 bytecode.
    *
    * @param bc the vector of bytecodes
    * @return a tuple of a new vector of bytecodes and virtual machine
    */
  override def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = {
    val vm = new VirtualMachineImpl()
    val newVm= (bc.head).execute(vm)
    val list = bc.to[ListBuffer]
    list.remove(0)
    (list.to[Vector], newVm)
  }

  /**
    * Pushes an integer value onto the virtual machine stack.
    *
    * @param value the integer to push
    * @return a new virtual machine with the integer `value` pushed
    */
  override def push(value: Int): VirtualMachine = {
    val vm = new VirtualMachineImpl()
    vm.stack = this.stack
    vm.stack += value
    System.out.println(vm.stack)
    vm
  }

  /**
    * Pops an integer value off of the virtual machine stack.
    *
    * @return (i, vm), where i is the integer popped and vm is the
    *         new virtual machine
    */
  override def pop(): (Int, VirtualMachine) = {
    System.out.println(stack.length + "EOOOO")
    var i = stack.last
    val vm = new VirtualMachineImpl()
    stack.remove(stack.length-1)
    vm.stack= stack
    (i,vm)
  }

  /**
    * Returns the state of the virtual machine stack.
    *
    * The value at index 0 is the value on the top of the stack.
    *
    * @return the state of the stack
    */
  override def state: Vector[Int] = {
    var newReversedStackList = new ListBuffer[Int]
    var i= stack.length-1
    while (i>=0){
      newReversedStackList += stack(i)
      i+= -1
    }
    newReversedStackList.to[Vector]
  }
}
