package _1_Basics

object Exercise2 {

  def main(args: Array[String]): Unit = {
    val addOne = (x: Int) => x + 1
    println(addOne(1))

    val add = (x: Int, y: Int) => x + y
    println(add(1, 2))

    val getTheAnswer = () => 42
    println(getTheAnswer())
  }

}
