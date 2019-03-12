package __11_Singleton_Objects

object Exercise1 {

  def main(args: Array[String]): Unit = {
    val person = Person.apply("Leopold")
    person.greeting()
  }

  class Person(name: String) {
    def greeting(): Unit = println(s"$name, Hi")
  }

  object Person {
    def apply(name: String): Person = new Person(name)
  }

}
