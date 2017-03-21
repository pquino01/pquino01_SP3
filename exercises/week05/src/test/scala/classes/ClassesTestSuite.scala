package classes

import org.scalatest.FunSuite

/**
  * Created by pablo on 20/03/2017.
  */
class ClassesTestSuite extends FunSuite {

  test("Increment and dicrement Counter from Counter class") {
    assert(new Counter(10).inc.dec.inc.inc.count==12)
  }

  test("Increment Counter by 5 from Counter class") {
    assert(new Counter(10,5).inc.count==15)
  }

  test("Increment/decrement Counter with default value from CounterCase class ") {
    val c1=new CounterCase()
    val c2=c1.copy(count=0,inc_dec=1)
    assert(c1.inc.count==1)
    assert(c2.inc.count==1)
  }

  test("Add 5 to counter passing Adder class to CounterCase class") {
    val ad= new Adder(5)
    assert(new CounterCase().adjust(ad).count==5)
  }

  test("call companion object Person, method apply passing a full name and returning array [name,lastName]") {
    val me= Person.apply("Pablo Quinoa")
    assert(me(0).equals("Pablo"))
    assert(me(1).equals("Quinoa"))
  }

  test("Directors and films"){
    val eastwood = new Director("Clint", "Eastwood", 1930)
    val mcTiernan = new Director("John", "McTiernan", 1951)
    val nolan = new Director("Christopher", "Nolan", 1970)
    val someGuy = new Director("Just", "Some Guy", 1990)

    val memento = new Film("Memento", 2000, 8.5, nolan)
    val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
    val inception = new Film("Inception", 2010, 8.8, nolan)

    val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
    val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
    val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
    val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
    val invictus = new Film("Invictus", 2009, 7.4, eastwood)

    val predator = new Film("Predator", 1987, 7.9, mcTiernan)
    val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
    val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
    val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

    assert(eastwood.yearOfBirth==1930)
    assert(dieHard.director.name.equals("John McTiernan"))
    assert(invictus.isDirectedBy(nolan)==false)
    //companion objects
    assert(Director.apply1("Clint", "Eastwood", 1930).equals(eastwood))
    assert(Director.older(eastwood,mcTiernan).equals(eastwood))
    assert(Film.apply2("High Plains Drifter", 1973, 7.7, eastwood).equals(highPlainsDrifter))
    assert(Film.highestRating(highPlainsDrifter, outlawJoseyWales).equals( outlawJoseyWales))
    assert(Film.oldestDirectorAtTheTime(outlawJoseyWales,predator).equals(eastwood))
  }

}


