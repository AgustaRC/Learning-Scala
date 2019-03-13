package __12_Regular_Expression_Patterns

object Exercise2 {

  def main(args: Array[String]): Unit = {
    val pattern1 = "(S|s)cala".r
    val str1 = "Scala is scalable and cool"
    println(pattern1 replaceFirstIn(str1, "Java"))

    val pattern2 = """\d+""".r
    val str2 = "foo 123 bar 456"
    println(pattern2.findAllMatchIn(str2).toList)

    val dateNoDay = "2016-08"
    val dateWithDay = "2016-08-20"

    val YearAndMonth = """(\d{4})-([01][0-9])""".r
    val YearMonthAndDay = """(\d{4})-([01][0-9])-([012][0-9])""".r

    dateNoDay match {
      case YearAndMonth(_, _) => println("no day provided")
      case YearMonthAndDay(_, _, day) => println(s"day provided: it is $day")
    }

    dateWithDay match {
      case YearAndMonth(_, _) => println("no day provided")
      case YearMonthAndDay(_, _, day) => println(s"day provided: it is $day")
    }

    val Pattern = """^(?:foo|bar)\.baz""".r
    """foo.baz""" match {
      case Pattern() => println("ok")
      case _ => println("bleh")
    }
  }

}
