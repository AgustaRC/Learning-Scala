package _2_Unifed_Types

object Exercise4 {

  def main(args: Array[String]): Unit = {
    val list: List[Nothing] = List()
    assert(list == Nil)
    println(list)

    try {
      throwEx()
    } catch {
      case e: IllegalStateException => println(e)
    }

    val opt: Option[String] = None
    println(opt)
  }

  def throwEx(): Nothing = {
    throw new IllegalStateException()
  }
}
