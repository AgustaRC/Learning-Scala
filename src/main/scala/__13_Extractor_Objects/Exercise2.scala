package __13_Extractor_Objects

object Exercise2 {

  def main(args: Array[String]): Unit = {
    val students = List(
      Student("Harris", List(Address("LosAngeles", "California"))),
      Student("Reena", List(Address("Houston", "Texas"))),
      Student("Rob", List(Address("Dallas", "Texas"))),
      Student("Chris", List(Address("Jacksonville", "Florida")))
    )

    val Texas = new StringSeqContains("Texas")
    val names = students collect {
      case student @ City(Texas()) => student.name
    }

    println(names)
  }

  case class Student(name: String, address: Seq[Address])

  case class Address(city: String, state: String)

  class StringSeqContains(value: String) {
    def unapply(in: Seq[String]): Boolean = in contains value
  }

  object City {
    def unapply(s: Student): Option[Seq[String]] =
      Some(
        for (c <- s.address) yield c.state
      )
  }

}
