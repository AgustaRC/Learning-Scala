package __13_Extractor_Objects

object Exercise4 {

  def main(args: Array[String]): Unit = {
    val user1: User = new FreeUser("Daniel", 3000, 0.7d)
    val user2: User = new FreeUser("Leopold", 10000, 0.9d)

    for (user <- List(user1, user2)) {
      user match {
        case FreeUser(name, _, p) =>
          if (p > 0.75) println(s"$name, what can we do for you today?") else println(s"Hello $name")
        case PremiumUser(name, _) => println(s"Welcome back, dear $name")
      }
    }
  }

  trait User {
    def name: String
    def score: Int
  }

  class FreeUser(val name: String, val score: Int, val upgradeProbability: Double) extends User
  class PremiumUser(val name: String, val score: Int) extends User

  object FreeUser {
    def unapply(user: FreeUser): Option[(String, Int, Double)] = Some((user.name, user.score, user.upgradeProbability))
  }

  object PremiumUser {
    def unapply(user: PremiumUser): Option[(String, Int)] = Some((user.name, user.score))
  }
}
