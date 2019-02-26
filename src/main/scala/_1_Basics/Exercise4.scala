package _1_Basics

object Exercise4 {

  def main(args: Array[String]): Unit = {
    println(getSquareString(input = 10))
  }

  def getSquareString(input: Double): String = {
    val square = input * input
    square.toString
  }

}
