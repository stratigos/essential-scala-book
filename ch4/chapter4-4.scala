/**
  * Demonstrate the sum type ("is a, or") pattern. ➕
  * Case objects, rather than classes, are used since there are no fields or
  * methods on these types.
  * Ch4.4.4.1
  */
sealed trait TrafficLight
case object Red extends TrafficLight
case object Green extends TrafficLight
case object Yellow extends TrafficLight

/**
  * Demonstrate the sum type pattern - again! ⚜
  * This time its all fancypants with arrrrrrghs.
  * Ch4.4.4.2
  */
sealed trait Calculation
final case class Success(result: Int) extends Calculation
final case class Failure(reason: String) extends Calculation

/**
  * Product type ("has-a, and") pattern. ✖
  * Its made up of a few things!
  * Ch4.4.4.3
  */
sealed trait Source
case object Well extends Source
case object Spring extends Source
case object Tap extends Source
final case class BottledWater(size: Int, source: Source, carbonated: Boolean)
