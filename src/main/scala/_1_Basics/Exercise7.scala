package _1_Basics

object Exercise7 {

  def main(args: Array[String]): Unit = {
    val count: Int = Counter.increase()
    println(count)
    val newerCount: Int = Counter.increase()
    println(newerCount)
  }

}

object Counter {
  private var counter = 0

  def increase(): Int = {
    counter += 1
    counter
  }
}
