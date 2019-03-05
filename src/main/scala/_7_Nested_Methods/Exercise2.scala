package _7_Nested_Methods

object Exercise2 {

  def main(args: Array[String]): Unit = {
    outer()
  }

  val age: Int = 33
  def outer(): Unit = {
    val name: String = "Leopold"

    def inner(): Unit = {
      println(name)
    }

    def inner2(): Unit = {
      println(age)
    }

    inner()
    inner2()
  }
}
