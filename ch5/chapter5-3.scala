/**
  * Implement Tree as an algebraic data type with a `fold()` method 🌲
  * I actually am super confused on this one and am not sure if I know what
  * this is doing! 🙃
  *   - I think it may not actually be "do-ing" anything, but rather setting
  *     this structure up to be able to recursively do things 👨‍🏭
  *   - That is, it implements an interface to accept a pair of functions that
  *     traverses the `Tree` and does the functiony things to turn the contents
  *     of each `Node` into a `B` 🤔
  * Ch5.3.4.1
  */
sealed trait BasicTree[A] {
  def fold[B](node: (B, B) => B, leaf: A => B): B
}

final case class BasicNode[A](
    left: BasicTree[A],
    right: BasicTree[A]
) extends BasicTree[A] {
  def fold[B](node: (B, B) => B, leaf: A => B): B =
    node(left.fold(node, leaf), right.fold(node, leaf))
}

final case class BasicLeaf[A](value: A) extends BasicTree[A] {
  def fold[B](node: (B, B) => B, leaf: A => B): B =
    leaf(value) // but how does this `B` ⁉ How is it not an `A` ⁉
}

/**
  * Now use `fold()` to convert a `Tree[String]` into a `String` 🐈
  * use example:
  *   val tree: Tree[String] =
  *     Node(Node(Leaf("To"), Leaf("iterate")),
  *     Node(Node(Leaf("is"), Leaf("human,")),
  *     Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))))
  * Ch5.3.4.1
  */
sealed trait StringTree[A] {
  def fold[B](node: (B, B) => B, leaf: A => B): B
}

final case class StringNode[A](
    left: StringTree[A],
    right: StringTree[A]
) extends StringTree[A] {
  def fold[B](node: (B, B) => B, leaf: A => B): B =
    node(left.fold(node, leaf), right.fold(node, leaf))
}

final case class StringLeaf[A](value: A) extends StringTree[A] {
  def fold[B](node: (B, B) => B, leaf: A => B): B =
    leaf(value)
}

// tree.fold[String]((a, b) => a + " " + b, str => str)
