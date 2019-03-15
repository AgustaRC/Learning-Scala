package __13_Extractor_Objects

import scala.util.Random

object Exercise1 {

  def main(args: Array[String]): Unit = {
    val customerID = CustomerID("Leopold")
    customerID match {
      case CustomerID(name) => println(name)
      case _ => println("Could not extract a CustomerID")
    }

    println(customerID)
  }

  object CustomerID {
    def apply(name: String) = s"$name--${Random.nextLong()}"

    def unapply(customerId: String): Option[String] = {
      val name = customerId.split("--").head
      if (name.nonEmpty) Some(name) else None
    }
  }
}
