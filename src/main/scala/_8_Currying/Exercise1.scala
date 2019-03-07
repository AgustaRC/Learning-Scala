package _8_Currying

object Exercise1 {

  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5, 6, 7, 8)
    println(filter(list, modN(2)))
    println(filter(list, modN(3)))
  }

  def filter(xs: List[Int], p: Int => Boolean): List[Int] =
    if (xs.isEmpty) xs
    else if (p(xs.head)) xs.head :: filter(xs.tail, p)
    else filter(xs.tail, p)

  def modN(n: Int)(x: Int): Boolean = (x % n) == 0
}
