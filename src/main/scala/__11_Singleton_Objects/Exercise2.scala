package __11_Singleton_Objects

object Exercise2 {

  def main(args: Array[String]): Unit = {
    println(SmartPhone.isInstanceOf[Phone])
    println(SmartPhone.isInstanceOf[Computer])
    println(SmartPhone.deviceNumber())
  }

  object SmartPhone extends Phone with Computer {
    def deviceNumber(): String = "S1989902002"
  }

  trait Computer
  class Phone
}
