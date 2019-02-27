package _2_Unifed_Types

object Exercise1 {

  def main(args: Array[String]): Unit = {
    val list: List[Any] = List(
      "a string",
      732,
      'c',
      true,
      () => "an anonymous function returning a string"
    )

    list.foreach(element => println(element))
  }

}
