package _8_Currying

object Exercise3 {

  def main(args: Array[String]): Unit = {
    val a = curry("s1")_
    println(a)

    val b = a("s2")
    println(b)

    val c = b("s3")
    println(c)
  }


  def curry(s1: String)(s2: String)(s3: String): String = {
    println("curry")
    s1 + s2 + s3
  }

}
