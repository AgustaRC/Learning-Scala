# 변수 
* **var**(Mutable)
```scala
var x = 1 + 1
x = 3 // ok
```
* **val**(Immutable)
```scala
val x: Int = 1 + 1
x = 3 // compile error
```
</br>

# 블록
* 아래와 같이 함수의 인자로 블록과 함께 표현식 대입 가능
```scala
println({
  val x = 1 + 1
  x + 1
}) // 3
```
</br>

# 함수
* 아래와 같이 익명 함수 선언 가능
```scala
(x: Int) => x + 1
```
* 모든 함수가 값이 될 수 있기 때문에 아래와 같이 변수에 할당할 수 있다.
```scala
val addOne = (x: Int) => x + 1
println(addOne(1)) // 2
```
* 아래와 같이 여러 개의 인자 또는 인자 없는 함수로도 할당할 수 있다.
```scala
val add = (x: Int, y: Int) => x + y
println(add(1, 2)) // 3
val getTheAnswer = () => 42
println(getTheAnswer()) // 42
```
</br>

# 메소드
* 함수의 거의 비슷해 보이지만 메소드는 ```def``` 키워드로 선언되며 이름을 가진다.
```scala
def add(x: Int, y: Int): Int = x + y
```
* 반환 타입은 생략 가능하고 메소드 내부에도 정의할 수 있다.
```scala
def outer(): Unit = {
  def add(x: Int, y: Int) = x + y
}
```
* 아래와 같은 형태의 파라미터 선언과 호출도 가능
```scala
def addThenMultiply(x: Int)(y: Int)(multiplier: Int): Int = (x + y) * multiplier
println(addThenMultiply(1)(1)(2)) // 4
```
* 스칼라는 return 키워드가 있지만 거의 사용되지 않는다. 
* 아래와 같이 블록 내의 마지막 표현식이 반환값으로 사용된다.
```scala
def getSquareString(input: Double): String = {
  val square = input * input
  square.toString
}
```
</br>

# 클래스
* 클래스 선언은 Java나 Kotlin처럼 ```class``` 키워드로 선언한다.
* 싱글톤의 경우 Kotlin과 Scala는 ```object```로 선언하면 된다. 
* Kotlin처럼 생성자 매개변수 선언 시 ```val```, ```var```, ```private```, ```protected``` 설정 가능
```scala
class Greeter(private val prefix: String, protected var suffix: String) {
  def greet(name: String): Unit =
    println(prefix + name + suffix)
}
```
* 인스턴스 생성 시 Java와 마찬가지로 ```new``` 키워드가 붙는다. 
```scala
val greeter = new Greeter("Hello, ", "!")
greeter.greet("Scala developer")
```
</br>

# 케이스 클래스
* 스칼라에는 특별한 케이스 클래스라는 것이 있다. 
* 패턴 매칭에 유용하게 사용될 수 있다는데 Kotlin의 ```sealed class```가 여기에서 아이디어를 얻은 것인가??
* 케이스 클래스 선언은 ```class``` 앞에 ```case``` 키워드가 붙는다. 
```scala
case class Point(x: Int, y: Int)
```
* 케이스 클래스는 기본적으로 불변이고 값에 의해 비교된다. 
* 일반 클래스가 인스턴스 생성 시 ```new``` 키워드가 필요했던 반면 케이스 클래스는 ```new``` 키워드를 필요로 하지 않는다. 
```scala
val p1 = Point(1, 2)
val p2 = Point(1, 2)
val p3 = Point(2, 3)
assert(p1 == p2, "p1 and p2 are the same.")
assert(p2 != p3, "p2 and p3 are different.")
```
* 설계 원칙에는 어긋나는 것 같지만 필드는 ```var```로 선언하면 값을 변경하는 것도 가능
```scala
val p1 = Point(1, 2)
val p2 = Point(1, 2)
val p3 = Point(3, 2)
assert(p1 == p2, "p1 and p2 are the same.")
assert(p2 != p3, "p2 and p3 are different.")

p2.x = 3
assert(p2 == p3, "p2 and p3 are the same.")
```
</br>

# 오브젝트
* Kotlin과 마찬가지로 ```object```로 선언을 하면 싱글톤이 된다.
```scala
object Counter {
  private var counter = 0

  def increase(): Int = {
    counter += 1
    counter
  }
}

val count: Int = Counter.increase()
println(count) // 1
val newerCount: Int = Counter.increase()
println(newerCount) // 2
```
</br>

# 트레잇
* Java와 Kotlin의 interface와 비슷한 개념인 듯
* 필드와 메소드 바디를 가질 수 있다.
```scala
trait Greeter {
  def greet(name: String): Unit =
    println("Hello, " + name + "!")
}

class DefaultGreeter extends Greeter
class CustomizableGreeter(prefix: String, postfix: String) extends Greeter {
  override def greet(name: String): Unit = {
    println(prefix + name + postfix)
  }
}

val greeter = new DefaultGreeter()
greeter.greet("Scala developer")

val customGreeter = new CustomizableGreeter(prefix = "How are you, ", postfix = "?")
customGreeter.greet("Scala developer")
```
