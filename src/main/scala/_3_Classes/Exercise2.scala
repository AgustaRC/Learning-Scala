package _3_Classes

object Exercise2 {

  def main(args: Array[String]): Unit = {
    val point = new Point(2, 3)
    println(point)
    point.move(3, 2)
    println(point)
  }

  class Point(var x: Int, var y: Int) {

    def move(dx: Int, dy: Int): Unit = {
      x += dx
      y += dy
    }

    override def toString: String = s"($x, $y)"
  }
}
