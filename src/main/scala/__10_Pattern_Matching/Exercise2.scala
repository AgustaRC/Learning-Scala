package __10_Pattern_Matching

object Exercise2 {

  def main(args: Array[String]): Unit = {
    val sms = SMS(caller = "12345", message = "Are you there?")
    println(showNotification(sms))

    val voiceRecording = VoiceRecording(contactName = "Tom", link = "voicerecording.org/id/123")
    println(showNotification(voiceRecording))
  }

  abstract class Notification

  case class Email(sender: String, title: String, body: String) extends Notification

  case class SMS(caller: String, message: String) extends Notification

  case class VoiceRecording(contactName: String, link: String) extends Notification

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(sender, title, _) =>
        s"You got an email from $sender with title: $title"
      case SMS(caller, message) =>
        s"You got an SMS from $caller! Message : $message"
      case VoiceRecording(contactName, link) =>
        s"You received a Voice Recording from $contactName! Click the link to hear it: $link"
    }
  }
}
