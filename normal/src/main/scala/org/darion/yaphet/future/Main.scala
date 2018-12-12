package org.darion.yaphet.future

import scala.concurrent.Future

object Main {
  def main(args: Array[String]): Unit = {
    import scala.concurrent.ExecutionContext.Implicits.global

    val s = "Hello"
    val f: Future[String] = Future {
      s + " future!"
    }

    f foreach {
      msg => println(msg)
    }
  }
}
