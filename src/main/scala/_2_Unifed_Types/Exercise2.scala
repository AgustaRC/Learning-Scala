package _2_Unifed_Types

object Exercise2 {

  def main(args: Array[String]): Unit = {
    val valList: List[AnyVal] = List(
      732,
      'c',
      true
    )

    val refList: List[AnyRef] = List(
      () => 10,
      "Scala"
    )

    valList.foreach(e => println(e))
    refList.foreach(e => println(e))
  }

}
