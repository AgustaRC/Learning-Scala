package _3_Classes

object Exercise1 {

  def main(args: Array[String]): Unit = {
    val user1 = new User
    val user2 = new User()
    val person1 = new Person()
    val person2 = new Person(name = "Leopold")
  }

  class User
  class Person(name: String = "default")
}
