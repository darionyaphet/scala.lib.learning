package org.darion.yaphet.cats.data_types

object EitherMain {
  def main(args: Array[String]): Unit = {
    val e1: Either[String, Int] = Right(5)
    println(e1.right.map(_ + 1))

    val e2: Either[String, Int] = Left("hello")
    println(e2.right.map(_ + 1))

    import cats.syntax.either._
    val right: Either[String, Int] = Right(5)
    println(right.map(_ + 1))

    val left: Either[String, Int] = Left("hello")
    println(left.map(_ + 1))
  }
}
