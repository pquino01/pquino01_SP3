package decorator

class GreenOlives(val newPizza: Pizza) extends PizzaDecorator(newPizza) {

  override def getDesc: String = {
    return newPizza.getDesc + ", green olives"
  }

  override def getPrice: Double = {
    return newPizza.getPrice + 5.47
  }
}
