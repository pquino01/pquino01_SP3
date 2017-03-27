package implementation

import bc.{ByteCode, InvalidBytecodeException}

import scala.collection.mutable.ListBuffer


/**
  * This class is an adapter that adapts the vendor parser and bytecode
  * parser with a virtual parser that transforms a textual bytecode program
  * into a vector of bytecode objects.
  *
  * @author Ullash Hazarika, Pablo Quinoa
  */
class VirtualMachineParserImpl extends vm.VirtualMachineParser {
  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a file into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program file correctly.
    *
    * @param file the file containing a program
    * @return a vector of bytecodes
    */
  override def parse(file: String): Vector[ByteCode] = {
    val pgParserImpl = new ProgramParserImpl
    val bcParserImpl = new ByteCodeParserImpl
    //using a list to add the Bytecodes, as the list is mutable
    var bList = new ListBuffer[Byte]()
    val inst1= pgParserImpl.parse(file)
    for(a <- inst1){
      //"iconst" has an argument
      if (a.name.equals("iconst")){
        bList +=  bcParserImpl.bytecode(a.name)
        bList += a.args(0).toByte
      }else if (bcParserImpl.names.contains(a.name)){
        bList += bcParserImpl.bytecode(a.name)
      }
      else {
        throw new InvalidBytecodeException("given bytecode is unknown!")
      }
    }
    //Converting the list to Vector, the return type
    bcParserImpl.parse(bList.to[Vector])
  }

  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a string into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program string correctly.
    *
    * @param str a string containing a program
    * @return a vector of bytecodes
    */
  override def parseString(str: String): Vector[ByteCode] = {
    val pgParserImpl = new ProgramParserImpl
    val bcParserImpl = new ByteCodeParserImpl
    //using a list to add the Bytecodes, as the list is mutable
    var bList = new ListBuffer[Byte]()
    val inst1= pgParserImpl.parseString(str)
    for(a <- inst1){
      //"iconst" has an argument
      if (a.name.equals("iconst")){
        bList +=  bcParserImpl.bytecode(a.name)
        bList += a.args(0).toByte
      }else if (bcParserImpl.names.contains(a.name)){
        bList += bcParserImpl.bytecode(a.name)
      }
      else {
        throw new InvalidBytecodeException("given bytecode is unknown!")
      }
    }
    //Converting the list to Vector, the return type
    bcParserImpl.parse(bList.to[Vector])
  }
}
