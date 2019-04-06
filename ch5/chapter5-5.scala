/**
  * Implement `.map()` for `Maybe[A]` 🤷
  *
  * Ch5.5.4.2
  */
sealed trait MapableMaybe[A] {
  def map[B](fn: A => B): MapableMaybe[B] =
    this match {
      case MapableFull(v) => MapableFull(fn(v))
      case MapableEmpty() => MapableEmpty[B]()
    }
}

case class MapableFull[A](value: A) extends MapableMaybe[A]
case class MapableEmpty[A]() extends MapableMaybe[A]

/**
  * Re-implement `.map()` in terms of a `.flatMap()` for `Maybe[A]` 🤷
  * I honestly have no idea how these implementations are actually different,
  * other than the second one has way more noise.
  *
  * Ch5.5.4.2
  */
sealed trait FlatMapableMaybe[A] {
  def flatMap[B](fn: A => FlatMapableMaybe[B]): FlatMapableMaybe[B] =
    this match {
      case FlatMapableFull(v) => fn(v)
      case FlatMapableEmpty() => FlatMapableEmpty[B]()
    }
  def map[B](fn: A => B): FlatMapableMaybe[B] =
    flatMap[B](v => FlatMapableFull(fn(v)))
}

final case class FlatMapableFull[A](value: A) extends FlatMapableMaybe[A]
final case class FlatMapableEmpty[A]() extends FlatMapableMaybe[A]

/**
  * Simple exercize: Given this list: ⛓
  *   `val list = List(1, 2, 3)`
  * ...return a List[Int] containing both all the elements and their negation.
  *
  * Ch5.5.4.3
  */
object ListWithFlatMapExample {
  val list = List(1, 2, 3)

  def useFlatMapToZipNegationsIntoListOfInts(): List[Int] =
    list.flatMap(x => List[Int](x, x * -1))
}

/**
  * Given this List: 🗺
  *   `val list: List[Maybe[Int]] = List(Full(3), Full(2), Full(1))`
  * ...return a List[Maybe[Int]] containing None for the odd elements.
  *
  * Ch5.5.4.3
  */
sealed trait Maybe[A] {
  def fold[B](full: A => B, empty: B): B =
    this match {
      case Full(v) => full(v)
      case Empty() => empty
    }
}

final case class Full[A](value: A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]

object AnotherListWIthFlatMapExample {
  val list: List[Maybe[Int]] = List(Full(3), Full(2), Full(1))

  // The example in the book is unclear and dumb and I want to complain about
  // it here. I mean really, why the heck would you doll on and on  about
  // flatMap, then ask for a method like this, and not mention that you expect
  // it to be a `map()` instead?
  // It feels like this author is teaching FP in Scala to folks that already
  // know FP in Scala.
  // So dont buy this book. 🚫💰
  def doTheNeedful() =
    list.flatMap(
      x =>
        List[Maybe[Int]] { x =>
          if (x % 2 == 0) Full(x) else Empty()
        }
    )
}
