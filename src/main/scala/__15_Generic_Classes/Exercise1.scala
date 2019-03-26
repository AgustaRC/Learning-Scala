package __15_Generic_Classes

object Exercise1 {

  def main(args: Array[String]): Unit = {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)

    println(stack.pop())
    println(stack.pop())
  }

  class Stack[T] {
    private var elements: List[T] = Nil

    def push(x: T): Unit = {
      elements = x :: elements
    }

    def peek: T = elements.head

    def pop(): T = {
      val top = peek
      elements = elements.tail
      top
    }
  }

}
