package decorator

class Meat(val newPizza: Pizza) extends PizzaDecorator(newPizza) {

  override def getDesc: String = {
    return newPizza.getDesc + ", meat"
  }

  override def getPrice: Double = {
    return newPizza.getPrice + 14.25
  }
}
