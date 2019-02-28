package _3_Classes

object Exercise4 {

  def main(args: Array[String]): Unit = {
    val point = new Point
    point.x = 99
    point.y = 100
    point.z = 100
  }

  class Point {
    private var _x = 0
    private var _y = 0
    private val bound = 100

    def x: Int = _x // Getter
    def x_= (newValue: Int): Unit = { // Setter
      if (newValue < bound) _x = newValue else printWarning()
    }

    def y: Int = _y
    def y_= (newValue: Int): Unit = {
      if (newValue < bound) _y = newValue else printWarning()
    }

    def z: Int = _y
    def z_= (newValue: Int): Unit = {
      if (newValue < bound) _y = newValue else printWarning()
    }

    private def printWarning(): Unit = println("WARNING: Out of bounds")
  }
}
