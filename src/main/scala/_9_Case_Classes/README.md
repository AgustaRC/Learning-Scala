# Case Classes
* 패턴 매칭에 따라 분리될 수 있다
* 기본적으로 케이스 클래스의 멤버 변수는 불변으로 선언됨
* 레퍼런스가 아닌 구조적인 동등성으로 비교
* ```new``` 없이 생성 가능
* ```new```가 필요 없는 이유는 컴파일러가 ```apply```, ```unapply``` 메소드를 가지는 companion object를 만들기 
* ```toString```, ```hasCode```, ```equals```를 자동으로 생성
* ```copy``` 메소드를 제공한다 (데이터 변경 시 ```copy```를 통해 특정 필드만 변경)
* 데이터를 담는 클래스에 적합
</br>

# 장점
* 불변성은 당신이 언제 어디서 그것들이 수정되는지 신경 쓸 필요 없게 만들어 준다.
* 값을 통한 비교는 여러분이 인스턴스들을 원시 값 들인 것처럼 비교할 수 있게 만들어 준다 - 클래스의 인스턴스들이 값 또는 참조를 통해 비교되는지와 같은 불확실성을 제거
* 패턴 매칭은 로직의 분기를 심플하게 만들어주며, 결국 적은 버그와 가독성 높은 코드로 이어진다.
</br>

# 케이스 클래스 선언
  * 기본적인 선언 방식
  ```scala
  case class Book(isbn: String)
  val frankenstein = Book("978-0486282114")
  ```
  ```scala
  abstract class Expr
  case class Var(name: String) extends Expr
  case class Number(num: Double) extends Expr
  case class UnOp(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
  
  val v = Var("x")
  val op = BinOp("+", Number(1), v)
  ```
</br>

# 특징
* **데이터의 불변성**
  * 다음과 같은 ```case class```가 있다고 했을 때 
  * 변수가 기본적으로 ```val``` 타입이기 때문에 값을 변경할 수 없다. 
  ```scala
  case class Message(sender: String, recipient: String, body: String)
  var message = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")
  message.sender = "joongwon100@gmail.com" // Compile error
  ```
  * 값을 변경하고자 한다면 ```copy``` 함수를 사용
  ```scala
  message = message.copy(sender = "joongwon100@gmail.com")
  ```
</br>

* **데이터의 값을 통한 동등성 비교**
  * 컴파일러가 케이스 클래스의 데이터를 기반으로 hashCode, equals 메소드를 자동 생성해주기 때문에 레퍼런스가 아니라 값에 의해 비교된다.
  ```scala
  val msg1 = Message("joongwon100@gmail.com", "joongwon999@naver.com", "Hi")
  val msg2 = Message("joongwon100@gmail.com", "joongwon@naver.com", "Hi")

  println(msg1 == msg2)
  println(msg1.hashCode() == msg2.hashCode())

  val msg3 = Message("joongwon100@gmail.com", "joongwon@naver.com", "Hi")
  println(msg2 == msg3)
  println(msg2.hashCode() == msg3.hashCode())
  ```
