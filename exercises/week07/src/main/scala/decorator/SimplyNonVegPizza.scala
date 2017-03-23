package decorator

class SimplyNonVegPizza extends Pizza {
  def getDesc: String = {
    return "Simply non veg pizza"
  }

  def getPrice: Double = {
    return 350
  }
}
