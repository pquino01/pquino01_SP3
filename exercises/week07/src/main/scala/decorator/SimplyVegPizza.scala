package decorator

class SimplyVegPizza extends Pizza {
  def getDesc: String = {
    return "Simply veg pizza"
  }

  def getPrice: Double = {
    return 230
  }
}
