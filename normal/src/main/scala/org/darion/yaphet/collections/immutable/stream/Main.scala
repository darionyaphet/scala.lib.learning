package org.darion.yaphet.collections.immutable.stream

object Main {
  def main(args: Array[String]): Unit = {
    lazy val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }
    fibs take 10 foreach println

    lazy val fibs0: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs0.zip(
      fibs0.tail).map(n => {
      println("Adding %d and %d".format(n._1, n._2))
      n._1 + n._2
    })

    fibs0 take 5 foreach println
    fibs0 take 6 foreach println
  }
}
