package _8_Currying

object Exercise4 {

  def main(args: Array[String]): Unit = {
    val naver = account("Naver")

    val baik = naver("Baik")
    val leopold = naver("Leopold")

    println(baik("1111"))
    println(leopold("2222"))
  }

  def account(website: String): String => String => String = (id: String) => (password: String) =>
    "Website : %s, Id : %s, Password : %s".format(website, id, password)
}
