package factory

/**
  * Created by pablo on 22/03/2017.
  */
class ConcreteCreator {
  val productFactory: Creator = new Creator

  def makeConcreteProduct(): Product = {
    productFactory.makeProduct("Concrete")
  }
}
