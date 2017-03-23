package factory

/**
  * Created by pablo on 22/03/2017.
  */
class Creator {

  def makeProduct(newProductType: String): Product = {
    val newProduct: Product = null
    if (newProductType == "Concrete") {
      return new ConcreteProduct
    }
    else return null
  }

}
