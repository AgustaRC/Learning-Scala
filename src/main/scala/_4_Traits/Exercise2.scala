package _4_Traits

import scala.collection.mutable.ArrayBuffer

object Exercise2 {

  def main(args: Array[String]): Unit = {
    val cat = new Cat("Sally")
    val dog = new Dog("Harry")

    val animals = ArrayBuffer.empty[Pet]
    animals.append(cat)
    animals.append(dog)
    animals.foreach(pet => println(pet.name))
  }

  trait Pet {
    val name: String
  }

  class Cat(val name: String) extends Pet

  class Dog(val name: String) extends Pet

}
