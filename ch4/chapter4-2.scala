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
