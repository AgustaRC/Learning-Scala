package _7_Nested_Methods

object Exercise4 {

  def main(args: Array[String]): Unit = {
    println(plusAndSquare(2, 2))
  }

  def plusAndSquare(x: Int, y: Int): Int = {
    def plus(x: Int, y: Int): Int = x + y
    def square(x: Int): Int = x * x

    square(plus(x, y))
  }
}
