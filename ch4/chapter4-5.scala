/**
  * Demonstrate polymorphic data types 🐉
  * Ch4.5.6.1
  */
sealed trait TraffickLight {
  def next: TraffickLight
}
case object Red extends TraffickLight {
  def next: TraffickLight = Green
}
case object Green extends TraffickLight {
  def next: TraffickLight = Yellow
}
case object Yellow extends TraffickLight {
  def next: TraffickLight = Red
}

/**
  * Now do the same thing with pattern matching 🎼
  * The author wants you to believe this is the best approach, since it does
  * not depend on external data, only one implementation is needed, and the
  * structure of the state machine is more clear and cohesive.
  * Ch4.5.6.1
  */
sealed trait TrafficLight {
  def next: TrafficLight =
    this match {
      case Red    => Green
      case Green  => Yellow
      case Yellow => Red
    }
}
case object Red extends TrafficLight
case object Green extends TrafficLight
case object Yellow extends TrafficLight

/**
  * Demonstrate methods with unusual shapes! 📛
  * This uses the structural recursion pattern, but is not yet a full
  * implementation.
  * Ch4.5.6.2
  */
/***************************************************************
  sealed trait Calculation
  final case class Success(result: Int) extends Calculation
  final case class Failure(reason: String) extends Calculation
****************************************************************/
object Calculator {
  def +(calc: Calculation, operand: Int): Calculation =
    calc match {
      case Success(result) => Success(result + operand)
      case Failure(reason) => Failure(reason)
    }
  def -(calc: Calculation, operand: Int): Calculation =
    calc match {
      case Success(result) => Success(result - operand)
      case Failure(reason) => Failure(reason)
    }
  def /(calc: Calculation, operand: Int): Calculation =
    calc match {
      case Success(result) =>
        operand match {
          case 0 => Failure("Division by zero")
          case _ => Success(result / operand)
        }
      case Failure(reason) => Failure(reason)
    }
}
