package _1_Basics

object Exercise1 {

  def main(args: Array[String]): Unit = {
    exercise1()
    exercise2()
    exercise3()
    exercise4()
  }

  def exercise1() {
    print("exercise1 : ")
    println({
      val x = 1 + 1
      x + 1
    })
  }

  def exercise2(): Unit = {
    print("exercise2 : ")
    val addOne = (x: Int) => x + 1
    println(addOne(1))

    val add = (x: Int, y: Int) => x + y
    println(add(1, 2))

    val getTheAnswer = () => 42
    println(getTheAnswer())
  }

  def exercise3(): Unit = {
    print("exercise3 : ")
    def add(x: Int, y: Int) = x + y
    println(add(1, 2))
  }

  def exercise4(): Unit = {
    print("exercise4 : ")
    println(addThenMultiply(1)(1)(2))
  }

  def addThenMultiply(x: Int)(y: Int)(multiplier: Int): Int = (x + y) * multiplier
}
