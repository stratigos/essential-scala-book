/**
  * Not yet Tail Call Optimization 🍸
  * Define recursive object, then create a recursive methods that return values
  * like lengths or products of the Linked List.
  * Ch4.6.3.1
  */
sealed trait IntList {
  def length: Int =
    this match {
      case End          => 0
      case Pair(hd, tl) => 1 + tl.length
    }

  def product: Int =
    this match {
      case End          => 1
      case Pair(hd, tl) => hd * tl.product
    }

  def double: IntList =
    this match {
      case End          => End
      case Pair(hd, tl) => Pair(hd * 2, tl.double)
    }
}

case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

/**
  * Implement a B-Tree as an algebraic datatype. 🌳
  * Implement methods such as `sum` and `double` on the Tree using pattern
  * matching.
  * Ch4.6.3.2
  */
sealed trait Tree
final case class Node(l: Tree, r: Tree) extends Tree
final case class Leaf(elt: Int) extends Tree

object TreeCalculations {
  def sum(tree: Tree): Int =
    tree match {
      case Leaf(value) => value
      case Node(l, r)  => sum(l) + sum(r)
    }

  def double(tree: Tree): Tree =
    tree match {
      case Leaf(value) => Lead(value * 2)
      case Node(l, r)  => Node(double(l), double(r))
    }
}

/**
  * Implement a B-Tree as an algebraic datatype. 🌴
  * Implement methods such as `sum` and `double` on the Tree using polymorphism
  * matching.
  * Ch4.6.3.2
  */
sealed trait PolymorphicTree {
  def sum: Int
  def double: PolymorphicTree
}

final case class PolyNode(
    left: PolymorphicTree,
    right: PolymorphicTree
) extends PolymorphicTree {
  def sum: Int = left.sum + right.sum

  def double: PolymorphicTree = PolyNode(left.double, right.double)
}

final case class PolyLeaf(value: Int) extends PolymorphicTree {
  def sum: Int = value

  def double: PolymorphicTree = PolyLeaf(value * 2)
}
