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

/**
  * Shape Traits
  * Ch4.1.4.2
  */
trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
}

case class Circle(radius: Double) extends Shape {
  val sides = 1
  val perimeter = 2 * math.Pi * radius
  val area = math.Pi * radius * radius
}

/*
  Since Rectangle and Square are quite similar, it stands that they could
  inherit from a common type.
  Commented below is an implementation of both, extending directly from Shape.
  More commonly, the logic / relationships for such types will be expressed by
  a common intermediate type, i.e., a Rectangular trait.
 */
// case class Rectangle(height: Double, width: Double) extends Shape {
//   val sides = 4
//   val perimeter = 2 * width + 2 * height
//   val area = width * height
// }

// case class Square(size: Double) extends Shape {
//   val sides = 4
//   val perimeter = 4 * size
//   val area = size * size
// }

trait Rectangular extends Shape {
  def height: Double
  def width: Double
  val sides = 4
  override val perimeter = 2 * width + 2 * height
  override val area = width * height
}

case class Rectangle(height: Double, width: Double) extends Rectangular

case class Square(size: Double) extends Rectangular {
  val height = size
  val width = size
}
