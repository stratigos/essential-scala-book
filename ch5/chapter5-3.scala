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
sealed trait Tree[A] {
  def fold[B](node: (B, B) => B, leaf: A => B): B
}

final case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A] {
  def fold[B](node: (B, B) => B, leaf: A => B): B =
    node(left.fold(node, leaf), right.fold(node, leaf))
}

final case class Leaf[A](value: A) extends Tree[A] {
  def fold[B](node: (B, B) => B, leaf: A => B): B =
    leaf(value) // but how does this `B` ⁉ How is it not an `A` ⁉
}
