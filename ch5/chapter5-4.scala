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
