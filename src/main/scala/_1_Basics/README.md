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
* 아래와 같이 여러 개의 인자 또는 인자 없는 함수로도 할당 할 수 있다.
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
* 반환타입은 생략 가능하고 메소드 내부에도 정의할 수 있다.
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
* 멋진데?
