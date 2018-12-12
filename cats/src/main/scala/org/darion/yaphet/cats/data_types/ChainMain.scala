package org.darion.yaphet.cats.data_types

import cats.data._

sealed abstract class Chain[+A]

final case object Empty extends Chain[Nothing]

final case class Singleton[A](a: A) extends Chain[A]

final case class Append[A](left: Chain[A], right: Chain[A]) extends Chain[A]

final case class Wrap[A](seq: Seq[A]) extends Chain[A]


object ChainMain {
//    def concat[A](c1: Chain[A], c2: Chain[A]): Chain[A] = {}

  def main(args: Array[String]): Unit = {

  }
}
