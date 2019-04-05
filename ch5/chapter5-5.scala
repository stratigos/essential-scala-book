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
