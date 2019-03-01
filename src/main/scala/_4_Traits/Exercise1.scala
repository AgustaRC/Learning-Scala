package _4_Traits

object Exercise1 {

  def main(args: Array[String]): Unit = {
    val iterator = new IntIterator(10)
    println(iterator.next())
    println(iterator.next())

    val iterator2 = new NoneOverrideIntIterator(10)
    println(iterator2.next())
    println(iterator2.next())
  }

  trait Iterator[T] {
    def hasNext: Boolean

    def next(): T
  }

  class IntIterator(to: Int) extends Iterator[Int] {
    private var current = 0

    override def hasNext: Boolean = current < to

    override def next(): Int = {
      if (hasNext) {
        val t = current
        current += 1
        t
      } else 0
    }
  }

  class NoneOverrideIntIterator(to: Int) extends Iterator[Int] {
    private var current = 0

    def hasNext: Boolean = current < to

    def next(): Int = {
      if (hasNext) {
        val t = current
        current += 1
        t
      } else 0
    }
  }

}
