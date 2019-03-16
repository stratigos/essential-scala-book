/**
  * Not yet Tail Call Optimization 🍸
  * Define recursive object, then create a recursive methods that return values
  * like lengths or products of the Linked List.
  * Ch4.6.3.1
  */
sealed trait IntList {
  def length: Int =
    this match {
      case End          => 0
      case Pair(hd, tl) => 1 + tl.length
    }

  def product: Int =
    this match {
      case End          => 1
      case Pair(hd, tl) => hd * tl.product
    }

  def double: IntList =
    this match {
      case End          => End
      case Pair(hd, tl) => Pair(hd * 2, tl.double)
    }
}

case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList
