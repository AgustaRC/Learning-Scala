package _7_Nested_Methods

object Exercise1 {

  def main(args: Array[String]): Unit = {
    println(factorial(2))
    println(factorial(3))
  }

  def factorial(x: Int): Int = {
    def fact(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else fact(x - 1, x * accumulator)
    }

    fact(x, 1)
  }
}
