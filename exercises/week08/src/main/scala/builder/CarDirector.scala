package builder

// TODO

case class CarDirector(carBuilder: CarBuilder) {

  def getCar: Car = carBuilder.getCar

  def build{
    carBuilder.buildBodyStyle
    carBuilder.buildBreaks
    carBuilder.buildEngine
    carBuilder.buildFuelType
    carBuilder.buildPower
    carBuilder.buildWindows
    carBuilder.buildSeats
  }

}
