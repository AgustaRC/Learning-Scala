package _4_Traits

object Exercise3 {

  def main(args: Array[String]): Unit = {
    val iterator = new IntIterator(10)
    println(iterator.next())
    println(iterator.next())
    println(iterator.hasNext)
  }

  trait Iterator[T] {
    def hasNext: Boolean = false

    def next(): T
  }

  class IntIterator(to: Int) extends Iterator[Int] {
    private var current = 0

    override def hasNext: Boolean = super.hasNext

    override def next(): Int = {
      if (hasNext) {
        val t = current
        current += 1
        t
      } else 0
    }
  }
}
