package _8_Currying

object Exercise2 {

  def main(args: Array[String]): Unit = {
    val one = add(1)
    println(one)

    val two = one(1)
    println(two)

    val three = add(1)(2)
    println(three)
  }

  def add(x: Int): Int => Int = (y: Int) => x + y
}
