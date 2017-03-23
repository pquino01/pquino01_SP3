package decorator

class Ham(val newPizza: Pizza) extends PizzaDecorator(newPizza) {
  override def getDesc: String = {
    return newPizza.getDesc + ", ham"
  }

  override def getPrice: Double = {
    return newPizza.getPrice + 18.2
  }
}
