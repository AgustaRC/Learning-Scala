package __10_Pattern_Matching

object Exercise6 {

  def main(args: Array[String]): Unit = {
    guard(100)
    guard(1)
    guard("111")
    guard("")
  }

  def guard(x: Any): Unit = {
    x match {
      case target: Int if target > 10 => println("Greater than 10")
      case target: Int if target <= 10 => println("Less than 10 or equal to 10")
      case target: String if target.isEmpty => println("Empty")
      case _ => println("Others")
    }
  }
}
