package classes

/**
  * Created by pablo on 20/03/2017.
  */
class Counter (var count: Int,var inc_dec: Int){

  /**
    * A secondary constructor.
    */
  def this(count: Int) {
    this(count, 1);
  }

  def inc: Counter = {
    count+=inc_dec
    new Counter(count)
  }

  def dec: Counter = {
    count-=inc_dec
    new Counter(count)
  }

}

case class CounterCase (count: Int, inc_dec: Int) {

  /**
  * A secondary constructor.
  */
  def this() {
    this(0, 1);
  }

  def inc: Counter = {
    val countAux=count+inc_dec
    new Counter(countAux)
  }

  def dec: Counter = {
    val countAux=count-inc_dec
    new Counter(countAux)
  }

  def adjust(ad: Adder): Counter = {
    val countAux=ad.add(count)
    new Counter(countAux)
  }

}

class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

case class Person (firstName: String, lastName: String){}

object Person {
  def apply(fullName: String): Array[String] = {
    val parts = fullName.split(" ")
    parts
  }
}

case class Director(firstName: String, lastName: String, yearOfBirth: Int) {
  def name() : String = {firstName.concat(" " + lastName)}
}

object Director{
  def apply1(firstName: String, lastName: String, yearOfBirth: Int): Director = {
    new Director(firstName,lastName,yearOfBirth)
  }

  def older(d1: Director, d2: Director): Director = {
    if (d1.yearOfBirth < d2.yearOfBirth){return d1}
    d2
  }
}

case class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {

  def directorsAge() : Int = {
    yearOfRelease - director.yearOfBirth
  }

  def isDirectedBy(direct: Director) : Boolean = {
    if (director.equals(direct)){return true}
    false
  }
}

object Film{
  def apply2(name: String, yearOfRelease: Int, imdbRating: Double, director: Director): Film = {
    new Film(name,yearOfRelease,imdbRating,director)
  }

  def highestRating(f1: Film, f2: Film): Film = {
    if (f1.imdbRating > f2.imdbRating){return f1}
    f2
  }

  def oldestDirectorAtTheTime(f1: Film, f2: Film): Director = {
    val age1 = f1.yearOfRelease - f1.director.yearOfBirth
    val age2 = f2.yearOfRelease - f2.director.yearOfBirth
    if (age1>age2){return f1.director}
    f2.director
  }
}
