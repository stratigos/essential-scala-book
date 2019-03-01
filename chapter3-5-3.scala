/**
 * Pattern matching with simple case classes
 * Ch3.5.3.1
 */
case class Cat(name: String, color: String, food: String)

object ChipShop {
  def willServe(cat: Cat): Boolean =
    cat match {
      case Cat(_, _, "Chips") => true
      case Cat(_, _, _) => false
    }
}
