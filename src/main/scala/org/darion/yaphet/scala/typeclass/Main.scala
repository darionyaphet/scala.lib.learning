
trait Semigroup[A] {
  def combine(a1: A, a2: A): A
}

object Semigroup {
  def apply[A](implicit instance: Semigroup[A]) = instance

  implicit val intPlusInstance = new Semigroup[Int] {
    def combine(a1: Int, a2: Int): Int = a1 + a2
  }
}


object Main {
  def main(args: Array[String]): Unit = {
    println(Semigroup[Int].combine(1, 2))
  }
}