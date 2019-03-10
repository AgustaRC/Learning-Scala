package __10_Pattern_Matching

object Exercise3 {

  def main(args: Array[String]): Unit = {
    val alice = Person("Alice", 25)
    val bob = Person("Bob", 32)
    val leopold = Person("Leopold", 35)
    val jacob = Person("Jacob", 20)

    for (person <- List(alice, bob, leopold, jacob)) {
      person match {
        case Person("Alice", 25) => println("Hi Alice!")
        case Person("Bob", 32) => println("Hi Bob!")
        case Person("Leopold", 35) => println("Hi Leopold!")
        case Person(_, _) => println("Who are you?")
      }
    }
  }

  case class Person(name: String, age: Int)
}
