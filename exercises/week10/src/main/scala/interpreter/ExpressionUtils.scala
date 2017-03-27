package interpreter

object ExpressionUtils {

  def isOperator(s: String): Boolean = {
    if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){true}
    else{false}
  }

  def getOperator(s: String, left: Expression, right: Expression): Expression = {
    if (s.equals("+")){
      return new Add(left,right)
    }
    if (s.equals("-")){
      return new Subtract(left,right)
    }
    if (s.equals("*")){
      return new Product(left,right)
    }
    if (s.equals("/")){
      return new Division(left,right)
    }
    else{
      return null
    }
  }
}