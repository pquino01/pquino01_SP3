package implementation

import bc.{ByteCode, ByteCodeParser, ByteCodeValues}

import scala.collection.mutable.ListBuffer

/**
  * This class is a parser from vector of Bytes into vector of Bytecodes.
  *
  * @author Ullash Hazarika, Pablo Quinoa
  */
class ByteCodeParserImpl extends ByteCodeParser {

  /**
    * Parses a vector of `Byte` into a vector of `ByteCode`.
    *
    * @param bc a vector of bytes representing bytecodes
    * @return a vector of `ByteCode` objects
    */
  override def parse(bc: Vector[Byte]): Vector[ByteCode] = {
    val bcf = new ByteCodeFactoryImpl
    //we will transform the bc vector into a List of Bytes, just for the simplicity of using Lists instead of a vector
    var bcList = new ListBuffer[ByteCode]()
    var i=0
    while (i<bc.length){
      //if we read a Byte corresponding to 'bytecode("iconst")', we pass two arguments: the byte corresponding to 'iconst'
      //and also as 2nd argument the next element of the vector of bytes transformed from Byte to Integer. After this, we jump
      //through next element from the vector to skip this element that only represented an integer in Byte format.
      if (bc(i).equals(bytecode("iconst"))) {
        bcList += bcf.make(bc(i), bc(i + 1).toInt)
        i+=1
      }
      //for all the rest of bytes that are not 'iconst', just call the method make from byteCodeFactory passing only the byte
      else {
        bcList += bcf.make(bc(i))
      }
      i+=1
    }
    bcList.to[Vector]
  }

}
