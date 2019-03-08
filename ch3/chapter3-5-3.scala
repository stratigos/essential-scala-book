/**
  * Pattern matching with simple case classes
  * Ch3.5.3.1
  */
case class Cat(name: String, color: String, food: String)

object ChipShop {
  def willServe(cat: Cat): Boolean =
    cat match {
      case Cat(_, _, "Chips") => true
      case Cat(_, _, _)       => false
    }
}

/**
  * Pattern matching to derive a value associated with `Films` and `Directors`.
  * Ch3.5.3.2
  */
object Dad {
  def rate(film: Film): Double =
    film match {
      case Film(_, _, _, Director("Clint", "Eastwood", _)) => 10.0
      case Film(_, _, _, Director("John", "McTiernan", _)) => 7.0
      case _                                               => 3.0
    }
}
