package org.darion.yaphet.scalameta

import scala.meta._
import scala.meta.Member.Term

object Main {
  def main(args: Array[String]): Unit = {
    val term = "x + y /* adds x and y */".parse[Term]
    println(term)

    val listType = "List[ Int ]".parse[Type]
    println(listType)
  }
}
