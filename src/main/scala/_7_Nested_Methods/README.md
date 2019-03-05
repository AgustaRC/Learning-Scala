# Nested Methods
* 스칼라에선 중첩 함수를 정의할 수 있다.
* factorial 계산 함수
```scala
def factorial(x: Int): Int = {
  def fact(x: Int, accumulator: Int): Int = {
    if (x <= 1) accumulator
    else fact(x - 1, x * accumulator)
  }

  fact(x, 1)
}

println(factorial(2))
println(factorial(3))
```
</br>

* 이렇게 중첩 함수를 여러 개 선언할 수도 있고
* 중첩 함수 내부에서 외부 변수에 대한 접근 가능하다.
```scala
val age: Int = 33
def outer(): Unit = {
  val name: String = "Leopold"

  def inner(): Unit = {
    println(name)
  }

  def inner2(): Unit = {
    println(age)
  }

  inner()
  inner2()
}
```
</br>

* 어떤 문제를 해결할 때 유용하게 쓰일지 아직 감은 안 오지만 
* 재귀 형태나 아래와 같이 함수 내부에서 작업을 작게 나누고 하는 형태가 유용하지 않을까 싶네..
```scala
def plusAndSquare(x: Int, y: Int): Int = {
  def plus(x: Int, y: Int): Int = x + y
  def square(x: Int): Int = x * x

  square(plus(x, y))
}
```
* **챕터별로 기본적인 내용 정리하면 오픈소스 코드 좀 많이 봐야겠다.**


