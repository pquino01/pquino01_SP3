package implementation

import bc._

/**
  * This class creates new bytecodes given a byte and argument (factory of
  * Bytecodes)
  *
  * @author Ullash Hazarika, Pablo Quinoa
  */
class ByteCodeFactoryImpl extends ByteCodeFactory with ByteCodeValues {

  /**
    * This method creates a new [[ByteCode]] object given the `byte`
    * that corresponds to the bytecode (see [[ByteCodeValues]]. If
    * the bytecode requires arguments then an optional integer
    * argument is provided.
    *
    * This method throws an [[InvalidBytecodeException]] if the
    * given bytecode value is unknown.
    *
    * @param byte the byte code of a bytecode
    * @param args an optional integer argument (depends on bytecode)
    * @return a new bytecode object
    */
  override def make(byte: Byte, args: Int*): ByteCode = {
    if (byte.equals(bytecode("iconst"))) {
      new Iconst(args(0))
    }
    else if (byte.equals(bytecode("iadd"))) {
      new Iadd
    }
    else if (byte.equals(bytecode("isub"))) {
      new Isub
    }
    else if (byte.equals(bytecode("imul"))) {
      new Imul
    }
    else if (byte.equals(bytecode("idiv"))) {
      new Idiv
    }
    else if (byte.equals(bytecode("irem"))) {
      new Irem
    }
    else if (byte.equals(bytecode("ineg"))) {
      new Ineg
    }
    else if (byte.equals(bytecode("iinc"))) {
      new Iinc
    }
    else if (byte.equals(bytecode("idec"))) {
      new Idec
    }
    else if (byte.equals(bytecode("iswap"))) {
      new Iswap
    }
    else if (byte.equals(bytecode("idup"))) {
      new Idup
    }
    else if (byte.equals(bytecode("print"))) {
      new Print
    }
    else{
      throw new InvalidBytecodeException("given bytecode is unknown!")
    }
  }
}
