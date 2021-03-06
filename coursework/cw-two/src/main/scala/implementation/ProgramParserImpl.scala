package implementation

import vendor.Instruction

import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * This class implements the ProgramParser interface.
  * The class has two definitions which parses a file representation or
  * string representation of a bytecode program into an 'InstructionList'
  *
  * @author Ullash Hazarika, Pablo Quinoa
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
    //used a ListBuffer as it is mutable
    var tempa = new ListBuffer[String]()
    var temp1 = new ListBuffer[Instruction]()
    for (line <- Source.fromFile(file2).getLines()) {
      tempa += line
    }
    val tempb= tempa.to[Vector]
    for(a<-tempb){
      val a1=a.split(" ")
        if (a1(0) == "iconst") {
          val v = new Instruction(a1(0), Vector(a1(1).toInt))
          temp1 += v
        } else {
          val vec = scala.collection.immutable.Vector.empty
          val v = new Instruction(a1(0), vec)
          temp1 += v
        }
    }
    //converting the List to a Vector, the return type of the definition
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
    //used a ListBuffer as it is mutable
    var temp1 = new ListBuffer[Instruction]()
    for(a<-inst){
      val a1=a.split(" ")
        //"iconst" has argument
        if (a1(0) == "iconst") {
          val v = new Instruction(a1(0), Vector(a1(1).toInt))
          temp1 += v
        } else {
          //instructions other than "iconst" have null Vector as an argument. vec is the null Vector
          val vec = scala.collection.immutable.Vector.empty
          val v = new Instruction(a1(0), vec)
          temp1 += v
        }
    }
    //converting the List to a Vector, the return type of the definition
    val v2:InstructionList = temp1.to[Vector]
    v2

  }
}
