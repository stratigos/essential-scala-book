/**
  * Print Shapes
  * Use a singleton object to "draw" a Shape by printing a description of it to
  * the console.
  * Ch4.2.2.1
  * @see Ch4.1 examples for reference to Shape ⭕
  */
object Draw {
  def apply(shape: Shape): String =
    shape match {
      case Circle(radius) => s"A circle of radius ${radius}cm"
      case Rectangle(height, width) =>
        s"A rectangle of width ${width}cm and height ${height}cm"
      case Square(size) => s"A square with sides of size ${size}cm"
    }
}

/**
  * Add a sealed trait named Color, because that apparently makes things more
  * interesting.
  * This is a silly way of implementing them with what amounts to per-cent
  * values, instead of a more practical 0..256.
  * Ch4.2.2.2
  * @see Ch4.1 for refs to Shape
  */
sealed trait Color {
  def r: Double
  def g: Double
  def b: Double
  def isLight = (((r + g + b) / 3.0) > 0.5)
  def isDark = !isLight
}

case object Red extends Color {
  val r = 1.0
  val g = 0.0
  val b = 0.0
}

case object Yellow extends Color {
  val r = 1.0
  val g = 1.0
  val b = 0.0
}

case object Pink extends Color {
  val r = 1.0
  val g = 0.0
  val b = 1.0
}

final case class CustomColor(r: Double, g: Double, b: Double) extends Color

sealed trait ColoredShape extends Shape {
  def color: Color
}

// We havent used _extractors_ yet in this book, so dont try inheriting from
// the actual Color class 😉
final case class ColorCircle(radius: Double, color: Color) extends Shape {
  val sides = 1
  val perimeter = 2 * math.Pi * radius
  val area = math.Pi * radius * radius
}
