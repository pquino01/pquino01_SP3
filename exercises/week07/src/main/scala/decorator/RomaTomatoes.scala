package decorator

class RomaTomatoes(val newPizza: Pizza) extends PizzaDecorator(newPizza) {

  override def getDesc: String = {
    return newPizza.getDesc + ", roma tomatoes"
  }

  override def getPrice: Double = {
    return newPizza.getPrice + 5.20
  }
}
