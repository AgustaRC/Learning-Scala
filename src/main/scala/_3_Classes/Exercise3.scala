package _3_Classes

object Exercise3 {

  def main(args: Array[String]): Unit = {
    var point = new Point()
    print(point)
    point = new Point(x = 10)
    print(point)
    point = new Point(y = 10)
    print(point)
    point = new Point(y = 10, x = 20)
    print(point)
  }

  def print(point: Point): Unit = {
    println(s"(x : ${point.x}, y : ${point.y})")
  }

  class Point(var x: Int = 0, var y: Int = 0)
}
