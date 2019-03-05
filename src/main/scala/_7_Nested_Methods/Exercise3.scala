package _7_Nested_Methods

object Exercise3 {

  def main(args: Array[String]): Unit = {
    println("Max of 5,7,9 = " + max(5, 7, 9))
  }

  def max(a: Int, b: Int, c: Int): Int = {
    def max(x: Int, y: Int): Int = if (x > y) x else y

    max(a, max(b, c))
  }
}
