package xpay

import factory.ConcreteCreator
import org.scalatest.FunSuite

/**
  * Created by pablo on 22/03/2017.
  */
class XpayToPayDAdapterTest extends FunSuite {

  test("testCallPayDMethodOnXpayAdapter") {
    val xpay = new XpayImpl
    val xpayAdapter: PayD = new XpayToPayDAdapter(xpay)
    xpayAdapter.setCustCardNo("123456789")
    assert (xpayAdapter.getCustCardNo.equals("123456789"))
  }

}
