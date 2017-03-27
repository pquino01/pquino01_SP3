package implementation

import bc.ByteCode
import vm.VirtualMachine

import scala.collection.mutable.ListBuffer

/**
  * This class use some internal representation for a stack
  * and provide the correct operations defined by the VirtualMachine
  * trait (push,pop,execute,executeOne,state)
  *
  * @author Ullash Hazarika, Pablo Quinoa
  */
class VirtualMachineImpl extends VirtualMachine {

  //This is the stack of the virtual machine that the bytecode program will use
  var stack= new ListBuffer[Int]

  /**
    * Executes a vector of bytecodes. It will return a new virtual machine after executing
    * each of the bytecodes from the given vector as this is an "immutable" object
    *
    * @param bc a vector of bytecodes
    * @return a new virtual machine
    */
  override def execute(bc: Vector[ByteCode]): VirtualMachine = {
    val listBc=bc.to[ListBuffer]
    var i=0
    //iterate through the Vector of Bytecodes and execute them
    while (i<listBc.length){
      listBc(i).execute(this)
      i+=1
    }
    this
  }

  /**
    * Executes the next bytecode in the vector of bytecodes.This method only executes a single byte code
    * in the vector of bytecodes. It returns a tuple of the new vector of bytecodes (with the executed
    * bytecode removed) and the new virtual machine.
    *
    * @param bc the vector of bytecodes
    * @return a tuple of a new vector of bytecodes and virtual machine
    */
  override def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = {
    bc.head.execute(this)
    //converting the bc Vector to a List which is mutable, enabling to remove the executed Bytecode
    val list = bc.to[ListBuffer]
    list.remove(0)
    (list.to[Vector], this)
  }

  /**
    * Pushes an integer value onto the virtual machine stack.
    *
    * @param value the integer to push
    * @return a new virtual machine with the integer `value` pushed
    */
  override def push(value: Int): VirtualMachine = {
    stack += value
    this
  }

  /**
    * Pops an integer value off of the virtual machine stack.
    *
    * @return (i, vm), where i is the integer popped and vm is the
    *         new virtual machine
    */
  override def pop(): (Int, VirtualMachine) = {
    val i = stack.last
    stack.remove(stack.length-1)
    (i,this)
  }

  /**
    * Returns the state of the virtual machine stack.The value at index 0 is the
    * value on the top of the stack.
    *
    * @return the state of the stack
    */
  override def state: Vector[Int] = {
    var newReversedStackList = new ListBuffer[Int]
    var i= stack.length-1
    //reversing the List to get the Stack representation in the desired return format
    while (i>=0){
      newReversedStackList += stack(i)
      i+= -1
    }
    newReversedStackList.to[Vector]
  }
}
