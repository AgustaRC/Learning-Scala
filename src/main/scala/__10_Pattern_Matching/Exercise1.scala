package __10_Pattern_Matching

import scala.util.Random

object Exercise1 {

  def main(args: Array[String]): Unit = {
    println(matchTest(Random.nextInt(10)))
    println(matchTestAny("two"))
    println(matchTestAny(10))
    println(matchTestAny(List()))
    println(matchTestAny(10.0f))
  }

  def matchTest(x: Int): String = x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

  def matchTestAny(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case _: Int => "scala.Int"
    case _: Float | _: Double => "scala.Float or scala.Double"
    case _ => x.toString
  }
}
