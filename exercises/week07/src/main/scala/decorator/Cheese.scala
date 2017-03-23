package decorator

class Cheese(val newPizza: Pizza) extends PizzaDecorator(newPizza) {

  override def getDesc: String = {
    return newPizza.getDesc + ", cheese"
  }

  override def getPrice: Double = {
    return newPizza.getPrice + 20.72
  }
}
