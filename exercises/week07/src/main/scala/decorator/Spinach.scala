package decorator

class Spinach(val newPizza: Pizza) extends PizzaDecorator(newPizza) {

  override def getDesc: String = {
    return newPizza.getDesc + ", spinach"
  }

  override def getPrice: Double = {
    return newPizza.getPrice + 7.92
  }
}
