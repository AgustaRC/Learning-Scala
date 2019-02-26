package _1_Basics

object Exercise5 {

  def main(args: Array[String]): Unit = {
    val greeter = new Greeter("Hello, ", "!")
    greeter.greet("Scala developer")
  }

  class Greeter(private val prefix: String, protected var suffix: String) {
    def greet(name: String): Unit =
      println(prefix + name + suffix)
  }
}
