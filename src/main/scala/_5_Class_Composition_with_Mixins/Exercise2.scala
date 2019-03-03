package _5_Class_Composition_with_Mixins

object Exercise2 {

  def main(args: Array[String]): Unit = {
    val e = new E
    println(e.message)
  }

  abstract class A {
    val message: String = "A"
  }

  trait B extends A {
    override val message: String = "B"
  }

  trait C extends A {
    override val message: String = "C"
  }

  //  class E extends A with B with C
  class E extends A with C with B

//  class F
//  class G extends A with F compile error

}
