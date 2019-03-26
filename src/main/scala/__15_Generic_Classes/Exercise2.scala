package __15_Generic_Classes

object Exercise2 {

  def main(args: Array[String]): Unit = {
    val stack = new Stack[Fruit]
    val apple = new Apple
    val banana = new Banana

    stack.push(apple)
    stack.push(banana)

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

  class Fruit
  class Apple extends Fruit
  class Banana extends Fruit
}
