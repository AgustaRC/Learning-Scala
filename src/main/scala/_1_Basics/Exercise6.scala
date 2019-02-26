package _1_Basics

object Exercise6 {

  def main(args: Array[String]): Unit = {
    val p1 = Point(1, 2)
    val p2 = Point(1, 2)
    val p3 = Point(3, 2)
    assert(p1 == p2, "p1 and p2 are the same.")
    assert(p2 != p3, "p2 and p3 are different.")

    p2.x = 3
    assert(p2 == p3, "p2 and p3 are the same.")
    println()
  }

  case class Point(var x: Int, y: Int)
}
