package _5_Class_Composition_with_Mixins

object Exercise1 {

  def main(args: Array[String]): Unit = {
    val d = new D
    println(d.message)
    println(d.loudMessage)
  }

  abstract class A {
    val message: String
  }

  class B extends A {
    val message = "I'm an instance of class B"
  }

  trait C extends A {
    def loudMessage: String = message.toUpperCase()
  }

  class D extends B with C

}
