package org.darion.yaphet.collections.immutable.range

object Main {
  def main(args: Array[String]): Unit = {
    // range [start;end) with non-zero step value step.
    val r1 = 0 until 10
    println("start : " + r1.start + " end : " + r1.end + " step : " + r1.step)

    val r2 = r1.start until r1.end by r1.step + 1
    println(r2.length)
  }
}
