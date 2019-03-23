/**
  * Generic Types 🏢
  * Change the name of the following trait to `LinkedList` and make it generic
  * in the type of data stored in the list. 🔗
  * Ch5.1.3.2
  */
/*
  sealed trait IntList
  case object End extends IntList
  final case class Pair(head: Int, tail: IntList) extends IntList
 */ // `scalafmt` is fucking dumb as hell!!!!!! 😡

sealed trait BasicLinkedList[A]

final case class BasicPair(
    head: A,
    tail: BasicLinkedList[A]
) extends BasicLinkedList[A]

final case class BasicEnd[A]() extends BasicLinkedList

/**
  * Moar Generic Types 👔
  * Implement a `LinkedList.length()` method so that it can do things.
  * Ch5.1.3.2
  */
sealed trait LengthyLinkedList[A] {
  def length: Int =
    this match {
      case Pair(hd, tl) => 1 + tl.length
      case End()        => 0
    }
}

final case class LengthyPair[A](
    head: A,
    tail: LengthyLinkedList[A]
) extends LengthyLinkedList[A]

final case class LengthyEnd[A]() extends LengthyLinkedList[A]

/**
  * Even Moar Generic Types 🕴
  * Implement a `LinkedList.contains()` which check if a thing is in the list.
  * Implement a method `LinkedList.apply()` that returns the nth item in the
  * list.
  * Ch5.1.3.2
  */
sealed trait LoudLinkedList[A] {
  def apply(index: Int): A =
    this match {
      case Pair(hd, tl) =>
        if (index == 0)
          hd
        else
          tl(index - 1)
      case End() =>
        throw new Exception("Attempted to get element from an Empty list")
    }

  def contains(item: A): Boolean =
    this match {
      case Pair(hd, tl) =>
        if (hd == item)
          true
        else
          tl.contains(item)
      case End() => false
    }
}

final case class Pair[A](
    head: A,
    tail: LoudLinkedList[A]
) extends LoudLinkedList[A]

final case class End[A]() extends LoudLinkedList[A]

/**
  * Yet Another Example of Generic Types 👨‍💼
  * Implement the same `LinkedList.apply()` method, but code the Exception out
  * of this universe. Use a `Result` type to determine `Success` or `Failure`,
  * instead of noisy, obtuse, ambiguous, and non-type-safe Exceptions.
  * Ch5.1.3.2 (Yeap this is all the same plunking trite exercise! 💪)
  */
sealed trait Result[A]
case class Success[A](result: A) extends Result[A]
case class Failure[A](reason: String) extends Result[A]

sealed trait LinkedList[A] {
  def apply(index: Int): Result[A] =
    this match {
      case Pair(hd, tl) =>
        if (index == 0)
          Success(hd)
        else
          tl(index - 1)
      case End() =>
        Failure("Index out of bounds")
    }
}

final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

final case class End[A]() extends LinkedList[A]
