package __14_For_Comprehensions

object Exercise2 {

  def main(args: Array[String]): Unit = {
      foo(10, 10) foreach {
        case (i, j) => println(s"($i, $j)")
      }
  }

  def foo(n: Int, v: Int): IndexedSeq[(Int, Int)] =
    for (i <- 0 until n; j <- i until n if i + j == v) yield (i, j)
}
