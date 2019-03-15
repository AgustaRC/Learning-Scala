package __13_Extractor_Objects

object Exercise3 {

  def main(args: Array[String]): Unit = {
    val user: User = new PremiumUser("Daniel")
    user match {
      case FreeUser(name) => println(s"Hello $name")
      case PremiumUser(name) => println(s"Welcome back, dear $name")
    }
  }

  trait User {
    def name: String
  }

  class FreeUser(val name: String) extends User
  class PremiumUser(val name: String) extends User

  object FreeUser {
    def unapply(user: FreeUser): Option[String] = Some(user.name)
  }

  object PremiumUser {
    def unapply(user: PremiumUser): Option[String] = Some(user.name)
  }
}
