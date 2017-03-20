package implementation

import bc._

/**
  * Created by pablo on 17/03/2017.
  */
class ByteCodeFactoryImpl extends ByteCodeFactory with ByteCodeValues {
  /**
    * Returns a [[ByteCode]].
    *
    * This method creates a new [[ByteCode]] object given the `byte`
    * that corresponds to the bytecode (see [[ByteCodeValues]]. If
    * the bytecode requires arguments then an optional integer
    * argument is provided.
    *
    * This method should throw an [[InvalidBytecodeException]] if the
    * given bytecode value is unknown.
    *
    * @param byte the byte code of a bytecode
    * @param args an optional integer argument (depends on bytecode)
    * @return a new bytecode object
    */
  override def make(byte: Byte, args: Int*): ByteCode = {
    if (byte.equals(bytecode("iconst"))) {
      return new Iconst(args(0))
    }
    else if (byte.equals(bytecode("iadd"))) {
      return new Iadd
    }
    else if (byte.equals(bytecode("isub"))) {
      return new Isub
    }
    else if (byte.equals(bytecode("imul"))) {
      return new Imul
    }
    else if (byte.equals(bytecode("idiv"))) {
      return new Idiv
    }
    else if (byte.equals(bytecode("irem"))) {
      return new Irem
    }
    else if (byte.equals(bytecode("ineg"))) {
      return new Ineg
    }
    else if (byte.equals(bytecode("iinc"))) {
      return new Iinc
    }
    else if (byte.equals(bytecode("idec"))) {
      return new Idec
    }
    else if (byte.equals(bytecode("iswap"))) {
      return new Iswap
    }
    else if (byte.equals(bytecode("idup"))) {
      return new Idup
    }
    else if (byte.equals(bytecode("print"))) {
      return new Print
    }
    else{
      throw new InvalidBytecodeException("given bytecode is unknown!")
    }
  }
}
