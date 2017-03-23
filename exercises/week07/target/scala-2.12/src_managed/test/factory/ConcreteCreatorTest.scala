package factory

import org.scalatest.FunSuite

/**
  * Created by pablo on 22/03/2017.
  */
class ConcreteCreatorTest extends FunSuite {

  test("testMakeConcreteProduct") {
    var cProd = new ConcreteCreator
    assert (cProd.makeConcreteProduct().getType().equals("ConcreteProduct"))
  }


}
