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

case class Left[A, B](value: A) extends Sum
case class Right[A, B](value: B) extends Sum
