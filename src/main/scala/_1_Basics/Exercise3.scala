package _1_Basics

object Exercise3 {

  def main(args: Array[String]): Unit = {
    def add(x: Int, y: Int) = x + y
    println(add(1, 2))

    println(addThenMultiply(1)(1)(2))
  }

  def addThenMultiply(x: Int)(y: Int)(multiplier: Int): Int = (x + y) * multiplier
}
