package __10_Pattern_Matching

object Exercise5 {

  def main(args: Array[String]): Unit = {
    println(findPlaceToSit(Couch()))
    println(findPlaceToSit(Chair()))
  }

  sealed class Furniture
  case class Couch() extends Furniture
  case class Chair() extends Furniture

  def findPlaceToSit(piece: Furniture): String = piece match {
    case _: Couch => "Lie on the couch"
    case _: Chair => "Sit on the chair"
  }
}
