package decorator

/**
  * Created by pablo on 23/03/2017.
  */
abstract class PizzaDecorator (tempPizza: Pizza) extends Pizza{

  def getDesc: String = tempPizza.getDesc

  def getPrice: Double = tempPizza.getPrice
}
