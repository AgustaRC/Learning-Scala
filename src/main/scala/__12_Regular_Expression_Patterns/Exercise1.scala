package __12_Regular_Expression_Patterns

import scala.util.matching.Regex

object Exercise1 {

  def main(args: Array[String]): Unit = {
    val pattern: Regex = "[0-9]".r

    pattern.findFirstMatchIn("awesomepassword") match {
      case Some(_) => println("Password Ok")
      case None => println("Password must contain a number")
    }
  }

}
