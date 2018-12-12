package org.darion.yaphet.cats.monoids

trait Monoids[A] {
  def combine(x: A, y: A): A

  def empty: A
}

object MonoidsMain {
  def associativeLaw[A](x: A, y: A, z: A)(implicit m: Monoids[A]): Boolean =
    m.combine(x, m.combine(y, z)) == m.combine(m.combine(x, y), z)

  def identityLaw[A](x: A)(implicit m: Monoids[A]): Boolean =
    (m.combine(x, m.empty) == x) && (m.combine(m.empty, x) == x)

  def main(args: Array[String]): Unit = {

  }
}
