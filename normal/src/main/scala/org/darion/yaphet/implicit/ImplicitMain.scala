package org.darion.yaphet.`implicit`

class A {}

class Implicit(a: A) {
  def Test: Unit = println("Implicit")
}

object ImplicitMain {

  implicit def a2Implicit(a: A) = new Implicit(a)

  def ImplicitMethod(implicit name: String): Unit = println(name)

  implicit class Add(x: Int) {
    def inc(a: Int): Int = a + 1
  }


  def main(args: Array[String]): Unit = {
    val a = new A
    a.Test

    implicit val name = "hark"
    ImplicitMethod
    ImplicitMethod("kxy")

    println(2.inc(2))
  }
}
