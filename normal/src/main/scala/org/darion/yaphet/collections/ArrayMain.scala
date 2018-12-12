package org.darion.yaphet.collections

import java.util

object ArrayMain {
  def main(args: Array[String]): Unit = {
    val numbers = Array(1, 2, 3, 4)
    val first = numbers(0)
    numbers(3) = 100

    val biggerNumbers = numbers.map(_ * 2)
    println(util.Arrays.toString(biggerNumbers))
  }
}
