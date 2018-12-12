package org.darion.yaphet.cats.type_classes

import org.darion.yaphet.cats.type_classes.JSONWriterInstances._
import org.darion.yaphet.cats.type_classes.JSONSyntax._

object JSONMain {
  def main(args: Array[String]): Unit = {
    // Interface Objects
    println(JSON.toJSON(Person("Dave", "dave@example.com")))
    println(JSON.toJSON(Person("Dave", "dave@example.com"))(personWriter))

    println(Person("Dave", "dave@example.com").toJSON)

    implicitly[JSONWriter[String]]

  }
}
