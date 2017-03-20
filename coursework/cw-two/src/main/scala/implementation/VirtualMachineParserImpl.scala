package implementation
import bc.{ByteCode, InvalidBytecodeException}

import scala.collection.mutable.ListBuffer


/**
  * Created by pablo on 19/03/2017.
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
    var bList = new ListBuffer[Byte]()
    val inst1= pgParserImpl.parse(file)
    for(a <- inst1){
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
    var bList = new ListBuffer[Byte]()
    val inst1= pgParserImpl.parseString(str)
    for(a <- inst1){
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
    bcParserImpl.parse(bList.to[Vector])
  }
}
