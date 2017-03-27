package interpreter

/**
  * Created by pablo on 27/03/2017.
  */
class Division (private val leftExpression: Expression, private val rightExpression: Expression) extends Expression {

  override def interpret(): Int =
    leftExpression.interpret() / rightExpression.interpret()

}
