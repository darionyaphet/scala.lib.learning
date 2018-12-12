package org.darion.yaphet.typz

trait Printable extends Any {
  def print(): Unit = println(this)
}

class Wrapper(val underlying: Int) extends AnyVal with Printable

class WrapperValue(val underlying: Int) extends AnyVal {
  def foo: WrapperValue = new WrapperValue(underlying * 19)
}

object Main {
  def main(args: Array[String]): Unit = {
    val w = new Wrapper(3)
    w.print()
  }
}
