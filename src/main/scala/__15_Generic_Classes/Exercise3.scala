package __15_Generic_Classes

object Exercise3 {

  def main(args: Array[String]): Unit = {
    print[String]("Greet")
    print[Int](10)
  }

  def print[T](t: T): Unit = {
    println(t)
  }

}
