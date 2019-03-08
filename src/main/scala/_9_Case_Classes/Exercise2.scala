package _9_Case_Classes

object Exercise2 {

  def main(args: Array[String]): Unit = {
    var message = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")
    println(message.sender)

//    message.sender = "joongwon100@gmail.com" // Compile error

    message = message.copy(sender = "joongwon100@gmail.com")
    println(message.sender)


    val msg1 = Message("joongwon100@gmail.com", "joongwon999@naver.com", "Hi")
    val msg2 = Message("joongwon100@gmail.com", "joongwon@naver.com", "Hi")

    println(msg1 == msg2)
    println(msg1.hashCode() == msg2.hashCode())

    val msg3 = Message("joongwon100@gmail.com", "joongwon@naver.com", "Hi")
    println(msg2 == msg3)
    println(msg2.hashCode() == msg3.hashCode())
  }

  case class Message(sender: String, recipient: String, body: String)
}
