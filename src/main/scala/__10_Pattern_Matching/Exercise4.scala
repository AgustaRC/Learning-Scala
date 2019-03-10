package __10_Pattern_Matching

object Exercise4 {

  def main(args: Array[String]): Unit = {
    println(goIdle(Phone("S10")))
    println(goIdle(Computer("i5")))
  }

  abstract class Device
  case class Phone(model: String) extends Device {
    def screenOff = "Turning screen off"
  }

  case class Computer(model:String) extends Device {
    def screenSaverOn = "Turning screen saver on..."
  }

  def goIdle(device: Device): String = device match {
    case p: Phone => p.screenOff
    case c: Computer => c.screenSaverOn
  }
}
