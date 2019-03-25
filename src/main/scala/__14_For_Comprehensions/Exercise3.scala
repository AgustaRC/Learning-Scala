package __14_For_Comprehensions

object Exercise3 {

  def main(args: Array[String]): Unit = {
    println(event(0, 30))

    val fruits = List("apple", "banana", "orange")

    val names: List[String] = for (e <- fruits) yield  e.toUpperCase
    println(names)

    val lengths: List[Int] = for (e <- fruits) yield  e.length
    println(lengths)

    println(fruits.map(_.substring(0, 1)).map(_.toUpperCase))

    val result = for {
      e <- fruits
    } yield {
      e.substring(0, 1).toUpperCase
    }

    println(result)
  }

  def event(from: Int, to: Int): List[Int] =
    for (i <- List.range(from, to) if i % 2 == 0) yield i
}
