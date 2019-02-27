package _2_Unifed_Types

object Exercise3 {

  def main(args: Array[String]): Unit = {
    val l: Long = 987654321
    val f: Float = l

    val s: Short = 10
    var i: Int = s

    val c: Char = '☺'
    i = c

    println(f)
    println(i)
  }

}
