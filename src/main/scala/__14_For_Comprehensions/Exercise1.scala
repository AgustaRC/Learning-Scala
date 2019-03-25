package __14_For_Comprehensions

object Exercise1 {

  def main(args: Array[String]): Unit = {
    val users = List(
      User("Travis", 28),
      User("Jennifer", 44),
      User("Dennis", 23)
    )

    val twentySomethings = for (user <- users if user.age >= 20 && user.age < 30) yield user.name
    twentySomethings.foreach(name => println(name))
  }

  case class User(name: String, age: Int)
}
