package _6_HigherOrder_Functions

object Exercise2 {

  def main(args: Array[String]): Unit = {
    val endpoint = "users"
    val query = "id=1"
    val url = getURL(endpoint, query)
    println(url) // "https://www.example.com/users?id=1": String
  }

  def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
    val schema = if (ssl) "https://" else "http://"
    (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
  }

  def getURL: (String, String) => String = urlBuilder(ssl=true, "www.example.com")
}
