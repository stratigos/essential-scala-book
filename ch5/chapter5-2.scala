/**
  * Functions! 👨‍💻
  * Create an "abstract" method to pass into a list, and then name it `fold`
  * because reasons.
  * Then, implement `sum()`, `length()`, and `product()` in terms of `fold()`.
  * Ch5.2.3.1
  */
sealed trait IntList {
  def fold(end: Int, f: (Int, Int) => Int): Int =
    this match {
      case End              => end
      case Pair(head, tail) => f(head, tail.fold(end, f))
    }

  def length: Int =
    fold(0, (_, tail) => 1 + tail)

  def product: Int =
    fold(1, (head, tail) => head * tail)

  def sum: Int =
    fold(0, (head, tail) => head + tail)
}

case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

/**
  * More generalized functions! ✨
  * Now generalize `fold()` such that its return type is a Generic Type. This
  * allows for the behavior like the above, except for things that are not
  * `Int`, like a new list.
  * Ch5.2.3.1
  */
sealed trait GenIntList {
  def fold[A](end: A, f: (Int, A) => A): A =
    this match {
      case GenEnd              => end
      case GenPair(head, tail) => f(head, tail.fold(end, f))
    }

  def length: Int =
    fold[Int](0, (_, tail) => 1 + tail)

  def product: Int =
    fold[Int](1, (head, tail) => head * tail)

  def sum: Int =
    fold[Int](0, (head, tail) => head + tail)

  def double: GenIntList =
    fold[GenIntList](GenEnd, (head, tail) => GenPair(head * 2, tail))
}

case object GenEnd extends GenIntList

final case class GenPair(head: Int, tail: GenIntList) extends GenIntList
