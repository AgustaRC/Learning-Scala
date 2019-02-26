package _1_Basics

object Exercise8 {

  def main(args: Array[String]): Unit = {
    val greeter = new DefaultGreeter()
    greeter.greet("Scala developer")

    val customGreeter = new CustomizableGreeter(prefix = "How are you, ", postfix = "?")
    customGreeter.greet("Scala developer")
  }

}

trait Greeter {
  def greet(name: String): Unit =
    println("Hello, " + name + "!")
}

class DefaultGreeter extends Greeter
class CustomizableGreeter(prefix: String, postfix: String) extends Greeter {
  override def greet(name: String): Unit = {
    println(prefix + name + postfix)
  }
}
