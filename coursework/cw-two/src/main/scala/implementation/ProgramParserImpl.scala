package implementation

import vendor.Instruction

import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Created by User on 19/03/2017.
  */
class ProgramParserImpl extends vendor.ProgramParser{

  /**
    * Parses a file representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param file the file to parse
    * @return an instruction list
    */
  def parse(file: String): InstructionList = {

    val file2=file
    var tempa = new ListBuffer[String]()
    var temp1 = new ListBuffer[Instruction]()
    val names = Vector("iconst", "iadd", "isub", "imul", "idiv", "irem",
      "ineg", "iinc", "idec", "idup", "iswap", "print")

    for (line <- Source.fromFile(file2).getLines()) {
      tempa += line

    }
    val tempb= tempa.to[Vector]

    for(a<-tempb){
      val a1=a.split(" ")
      //if(names.contains(a1(0))) {
        if (a1(0) == "iconst") {
          val v = new Instruction(a1(0), Vector(a1(1).toInt))
          temp1 += v
        } else {
          val vec = scala.collection.immutable.Vector.empty
          val v = new Instruction(a1(0), vec)
          temp1 += v
        }
      //}
    }
    val v2:InstructionList = temp1.to[Vector]
    v2
  }

  /**
    * Parses a string representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param string the string to parse
    * @return an instruction list
    */
  def parseString(string: String): InstructionList ={

    val inst=string.split("\n").to[Vector]
    var temp1 = new ListBuffer[Instruction]()
    val names = Vector("iconst", "iadd", "isub", "imul", "idiv", "irem",
      "ineg", "iinc", "idec", "idup", "iswap", "print")

    for(a<-inst){
      val a1=a.split(" ")
      //if(names.contains(a1(0))) {
        if (a1(0) == "iconst") {
          val v = new Instruction(a1(0), Vector(a1(1).toInt))
          temp1 += v
        } else {
          val vec = scala.collection.immutable.Vector.empty
          val v = new Instruction(a1(0), vec)
          temp1 += v
        }
      //}
    }
    val v2:InstructionList = temp1.to[Vector]
    v2

  }
}
