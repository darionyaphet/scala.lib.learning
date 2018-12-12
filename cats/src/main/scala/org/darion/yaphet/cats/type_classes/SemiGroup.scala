package org.darion.yaphet.cats.type_classes

trait SemiGroup[A] {
  def combine(a1: A, a2: A): A
}

object SemiGroup {

  def apply[A](implicit instance: SemiGroup[A]) = instance

  implicit val intPlusInstance = new SemiGroup[Int] {
    override def combine(a1: Int, a2: Int): Int = {
      a1 + a2
    }
  }

  abstract class Syntax[A](implicit I: SemiGroup[A]) {
    def a1: A

    def |+|(a2: A): A = I.combine(a1, a2)
  }

  implicit def to[A](target: A)(implicit I: SemiGroup[A]): Syntax[A] = new Syntax[A] {
    override def a1: A = target
  }

}

object SemiGroupMain {
  def main(args: Array[String]): Unit = {
    import SemiGroup._
    println(SemiGroup[Int].combine(1, 2))
    println(1 |+| 2)
  }
}