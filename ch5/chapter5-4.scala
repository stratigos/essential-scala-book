/**
  * Create a "Generic Product Type" of two different types.
  * Example usage: 🍐
  *   `val pair = SimplePair[String, Int]("hi", 2)`
  *   `pair.one`
  *   `pair.two`
  * Ch5.4.1.1
  */
case class SimplePair[A, B](one: A, two: B)
