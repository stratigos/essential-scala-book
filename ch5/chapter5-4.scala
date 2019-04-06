/**
  * Create a "Generic Product Type" of two different types.
  * Example usage: 🍐
  *   `val pair = SimplePair[String, Int]("hi", 2)`
  *   `pair.one`
  *   `pair.two`
  * Ch5.4.1.1
  */
case class SimplePair[A, B](one: A, two: B)

/**
  * Implement a trait Sum[A, B] with two subtypes Left and Right.
  * Create type parameters so that Left and Right can wrap up values of
  * two different types.
  *
  * Ch5.4.3.1
  */
trait Sum[A, B]

case class Left[A, B](value: A) extends Sum[A, B]
case class Right[A, B](value: B) extends Sum[A, B]

/**
  * Implement a trait Maybe[A] with two subtypes, one of which has no value.
  * Example usage:
  *  `val perhaps: Maybe[Int] = Empty[Int]`
  *  `val perhaps: Maybe[Int] = Full(1)`
  *
  * Ch5.4.4.1
  */
trait Maybe[A]

case class Full[A](value: A) extends Maybe[A]
case class Empty[A]() extends Maybe[A]

/**
  * Implement `fold()` for a `Maybe[A]` 📁
  *
  * Ch5.4.6.2
  */
sealed trait FoldingMaybe[A] {
  def fold[B](full: A => B, empty: B): B =
    this match {
      case FoldingFull(v) => full(v)
      case FoldingEmpty() => empty
    }
}

final case class FoldingFull[A](value: A) extends FoldingMaybe[A]
final case class FoldingEmpty[A]() extends FoldingMaybe[A]

/**
  * Implement 'fold()' for `Sum[A, B]` 📂
  *
  * Ch5.4.6.3
  */
sealed trait FoldingSum[A, B] {
  def fold[C](left: A => C, right: B => C): C =
    this match {
      case Left(a)  => left(a)
      case Right(b) => right(b)
    }
}

case class FoldingLeft[A, B](value: A) extends FoldingSum[A, B]
case class FoldingRight[A, B](value: B) extends FoldingSum[A, B]
