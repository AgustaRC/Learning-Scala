# Extractor Objects
* 스칼라의 익스트랙터는 ```unapply```라는 메소드가 있는 객체
* 기존 타입에 대한 새로운 자신만의 패턴을 정의할 수 있다.
* ```unapply``` 메소드의 목적은 값을 매치시켜 각 부분을 나누는 것
* 반대로 값을 만들어내는 ```apply```라는 반대 방향 메소드가 익스트랙터 객체에 들어 있는 경우도 자주 있지만 ```apply``` 메소드가 패턴 매치를 위해 꼭 있어야 하는 건 아니다. 
* ```apply``` 메소드 구현은 (**선택적**), ```unapply``` 메소드 구현은 (**필수**)
</br>

* **간단한 익스트랙터 예제**
```scala
object CustomerID {
  def apply(name: String) = s"$name--${Random.nextLong()}"

  def unapply(customerId: String): Option[String] = {
    val name = customerId.split("--").head
    if (name.nonEmpty) Some(name) else None
  }
}

val customerID = CustomerID("Leopold")
customerID match {
  case CustomerID(name) => println(name)
  case _ => println("Could not extract a CustomerID")
}

println(customerID)
// Leopold
// Leopold--6592890079983473898
```
</br>

* **Boolean 익스트랙터**
```scala
case class Student(name: String, address: Seq[Address])

case class Address(city: String, state: String)

class StringSeqContains(value: String) {
  def unapply(in: Seq[String]): Boolean = in contains value
}

object City {
  def unapply(s: Student): Option[Seq[String]] =
    Some(
      for (c <- s.address) yield c.state
    )
}

val students = List(
  Student("Harris", List(Address("LosAngeles", "California"))),
  Student("Reena", List(Address("Houston", "Texas"))),
  Student("Rob", List(Address("Dallas", "Texas"))),
  Student("Chris", List(Address("Jacksonville", "Florida")))
)

val Texas = new StringSeqContains("Texas")
val names = students collect {
  case student @ City(Texas()) => student.name
}

println(names)
// List(Reena, Rob)
```
</br>

* **unapply 메소드의 반환 값 규칙**
  * 단순한 테스트라면 ```Boolean```을 반환한다.
  * 타입 ```T```의 단일 하위 값을 반환한다면, ```Option[T]```를 반환한다.
  * 여러 하위 값 ```T1, ..., Tn```를 반환하고 싶다면, 이를 ```Option[T1, ..., Tn)```과 같이 튜플로 묶어준다.
</br>

* **익스트랙터와 케이스 클래스**
  * 케이스 클래스는 아주 유용하지만 데이터의 구체적인 표현이 드러난다는 단점이 있다.
  * 익스트랙터를 사용하면 패턴과 그 패턴이 선택하는 객체의 내부 데이터 표현 사이에 아무런 관계가 없도록 만들 수 있다.
  * 이런 특성을 표현 독립성(Representation Independence)이라 한다.
  * 선택하려는 대상 타입과 다르게 만들 수 있으므로 패턴 매칭에 사용할 수 있는 패턴에 대한 더 많은 유연성을 제공한다.
  * 같은 데이터에 대해 다른 뷰를 제공하는 것과도 같음.
</br>

* **어디에 사용될까?**
  * 우선 정규 표현식에서 유용할 것 같고..
  * 다소 복잡한 규칙을 정의할 때?
  * 필터링이나 URL, Email 주소 추출 등 작업에도 유용할 듯
