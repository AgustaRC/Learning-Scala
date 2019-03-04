package _6_HigherOrder_Functions

object Exercise3 {

  def main(args: Array[String]): Unit = {
    val message = "Hello"

    println(HTMLStringDecorator(
      message,
      titleTag(message)
    ))

    val customers = Array("Mike", "Zara", "Peter")
    customers foreach remindPayment
  }

  def HTMLStringDecorator(text: String, f: String => String): String = f(text)

  def titleTag(data: String): String => String = {
    _: String => s"<title>$data</title>"
  }

  def forEach(a: Array[String], f:String => Unit): Unit = for (e <- a) f(e)

  def remindPayment(x: String): Unit = println("Payment reminder for " + x)
}
