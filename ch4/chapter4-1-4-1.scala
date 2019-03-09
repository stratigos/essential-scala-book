/**
  * Cat Simulator v2.1
  * Use Traits to model Tigers, Lions, Panthers, and Cats like they all be
  * Felines 😼
  * Ch4.1.4.1
  */
trait Feline {
  // No default implementations here, as they would not be suitable for all
  // subtypes of Feline.
  def color: String
  def sound: String
}

case class Lion(color: String, maneSize: Int) extends Feline {
  val sound = "roar"
}

case class Tiger(color: String) extends Feline {
  val sound = "ki ya"
}

case class Panther(color: String) extends Feline {
  val sound = "si"
}

case class Cat(color: String, food: String) extends Feline {
  val sound = "meow"
}

/*
  If some kind of "default" implementation is desired, it is best to implement
  an _intermediate type_, with the implementation common to multiple subtypes
  of Feline. E.g., BigCat, since all big Feline's have a _roar_.
 */

trait BigCat extends Feline {
  override val sound = "roar"
}

// case class Lion(color: String, maneSize: Int) extends BigCat
case class Smilodon(color: String, fangSize: Int) extends BigCat
case class SnoopLion(color: String, currentStrain: String) extends BigCat
case class JagPanther(color: String, clawSize: Int) extends BigCat
