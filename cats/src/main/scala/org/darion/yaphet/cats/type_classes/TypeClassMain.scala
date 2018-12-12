package org.darion.yaphet.cats.type_classes

class TypeClassMain {
  def sumInts(list: List[Int]): Int = list.foldRight(0)(_ + _)

  def concatStrings(list: List[String]): String = list.foldRight("")(_ ++ _)

  def unionSets[A](list: List[Set[A]]): Set[A] = list.foldRight(Set.empty[A])(_ union _)
}

trait Monoid[A] {
  def empty: A

  def combine(x: A, y: A): A
}

object TypeClassMain {

  def main(args: Array[String]): Unit = {

  }
}
