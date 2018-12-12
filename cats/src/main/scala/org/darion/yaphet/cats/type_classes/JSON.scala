package org.darion.yaphet.cats.type_classes

sealed trait JSON

final case class JSObject(get: Map[String, JSON]) extends JSON

final case class JSString(get: String) extends JSON

final case class JSNumber(get: Double) extends JSON

case object JSNull extends JSON

trait JSONWriter[A] {
  def write(value: A): JSON
}

final case class Person(name: String, email: String)

object JSONWriterInstances {
  implicit val stringWriter: JSONWriter[String] =
    (value: String) => {
      JSString(value)
    }

  implicit val personWriter: JSONWriter[Person] =
    (value: Person) => {
      JSObject(Map("name" -> JSString(value.name), "email" -> JSString(value.email)))
    }
}

object JSON {
  def toJSON[A](value: A)(implicit w: JSONWriter[A]): JSON = w.write(value)
}

object JSONSyntax {

  implicit class JSONWriterOps[A](value: A) {
    def toJSON(implicit w: JSONWriter[A]): JSON = w.write(value)
  }

}

