package _6_HigherOrder_Functions

object Exercise1 {

  def main(args: Array[String]): Unit = {
    val decorator = new Decorator("[", "]")
    println(apply(decorator.layout, 7))
  }

  def apply(f: Int => String, v: Int) = f(v)

  class Decorator(left: String, right: String) {
    def layout[T] (x: T): String = left + x.toString + right
  }
}
