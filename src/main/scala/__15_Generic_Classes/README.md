# 제네릭 클래스
  * Java와 거의 비슷하다.
  * Java는 ```angle brackets <>```으로 선언하는 반면 Scala는 ```square brackets []```으로 표현
  * ```Variances```, ```Upper Type Bounds```, ```Lower Type Bounds```는 다음 챕터에서 정리
  * 기본적으로 타입 파라미터로 선언하면 Scala도 무공변(```invariant```)이다.
  * 제네릭 클래스를 표현할 때 자주 써먹는 ```Stack``` 예제
  ```scala
  class Stack[T] {
    private var elements: List[T] = Nil

    def push(x: T): Unit = {
      elements = x :: elements
    }

    def peek: T = elements.head

    def pop(): T = {
      val top = peek
      elements = elements.tail
      top
    }
  }
  ```
  </br>
  
  * 메소드에서 제네릭이 쓰이면 ```Polymorphic Methods```라고 한다.
  * 이 내용은 ```Polymorphic Methods``` 챕터에서 알아보자.
  ```scala
  def print[T](t: T): Unit = {
    println(t)
  }
  
  print[String]("Greet")
  print[Int](10)
  ```
