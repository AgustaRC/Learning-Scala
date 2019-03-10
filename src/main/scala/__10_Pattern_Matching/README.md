# Pattern Matching
* 스칼라에서 제공하는 범용적인 빌트인 매칭 메커니즘
* Java의 ```switch```와 비슷하지만 훨씬 강력하다
* Kotlin의 ```when expression```과 비슷한 듯
* 성능에 민감한 코드가 있다면 최대한 ```case```문의 앞쪽에 배치시키자
</br>

# 기본 문법
* 아래와 같이 값에 의해 매칭 시킬 수 있다.
* ```case``` 문안에 ```|``` 을 이용해 논리합을 구성할 수도 있다.
* ```Int```, ```Float``` 등과 같은 특정 타입으로 매칭 시킬 수 있음.
* 패턴 매칭에서 ```_```는 Kotlin ```when```의 ```else```와 같은 역할 
* ```case``` 다음 대문자로 시작하는 이름이 오면 타입으로 간주
* 소문자로 시작하는 이름이 오면 변수로 간주
```scala
def matchTest(x: Int): String = x match {
  case 0 => "zero"
  case 1 => "one"
  case 2 => "two"
  case _ => "many"
}

def matchTestAny(x: Any): Any = x match {
  case 1 => "one"
  case "two" => 2
  case _: Int => "scala.Int"
  case _: Float | _: Double => "scala.Float or scala.Double"
  case _ => x.toString
}

println(matchTest(Random.nextInt(10))) //many
println(matchTestAny("two")) // 2
println(matchTestAny(10)) // scala.Int
println(matchTestAny(List())) // List()
println(matchTestAny(10.0f)) // scala.Float or scala.Double
```
</br>

# 케이스 클래스 매칭
* 아래와 같이 case class로 매칭 시킬 수 있다.
```scala
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
```
* 케이스 클래스의 값에 의한 매칭
```scala
case class Person(name: String, age: Int)

val alice = Person("Alice", 25)
val bob = Person("Bob", 32)
val leopold = Person("Leopold", 35)
val jacob = Person("Jacob", 20)

for (person <- List(alice, bob, leopold, jacob)) {
  person match {
    case Person("Alice", 25) => println("Hi Alice!")
    case Person("Bob", 32) => println("Hi Bob!")
    case Person("Leopold", 35) => println("Hi Leopold!")
    case Person(_, _) => println("Who are you?")
  }
}
```
* 타입으로만 비교하는 매칭
```scala
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

println(goIdle(Phone("S10")))
println(goIdle(Computer("i5")))
```
</br>

# Sealed class를 이용한 매칭
* ```trait```과 ```class```에 선언할 수 있는 ```sealed``` 키워드를 이용
* ```sealed```의 의미는 ```Kotlin```과 동일 (```sealed class```의 서브타입은 같은 파일 내에 존재해야 함)
* ```sealed```는 모든 서브타입을 알고 있다는 것을 보증한다
* 고로 catch all과 같은 ```case``` 구문이 필요 없음
```scala
sealed class Furniture
case class Couch() extends Furniture
case class Chair() extends Furniture

def findPlaceToSit(piece: Furniture): String = piece match {
  case _: Couch => "Lie on the couch"
  case _: Chair => "Sit on the chair"
}
```
</br>

# 패턴 가드
* ```case``` 문에 조건식을 걸어 구체적인 매칭을 설정할 수 있다.
```scala
def guard(x: Any): Unit = {
  x match {
    case target: Int if target > 10 => println("Greater than 10")
    case target: Int if target <= 10 => println("Less than 10 or equal to 10")
    case target: String if target.isEmpty => println("Empty")
    case _ => println("Others")
  }
}

guard(100) // Greater than 10
guard(1) // Less than 10 or equal to 10
guard("111") // Others
guard("") // Empty
```
