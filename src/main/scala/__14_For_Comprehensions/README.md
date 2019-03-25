# For Comprehensions
  * 시퀀스 컴프리헨션(Sequence comprehensions)을 표현하기 위한 간편한 문법
  * ```for (enumerators) yield e``` 와 같은 형태를 가짐
  * enumerators는 세미콜론으로 구분된 이뉴머레이터
  * 이뉴머레이터는 새로운 변수를 정의하는 생성자이거나 필터
  * ```for``` 문안에서 ```yield``` 키워드를 이용하여 ```for``` 문에서 생성한 값들의 시퀀스를 반환
  * 특정 컬렉션에서 새로운 컬렉션으로 생성 또는 변환하는 작업이 용이하다.
  </br>
  
  * ```for```와 ```yield```를 이용하여 짝수만을 출력하는 예제
  ```scala
  def event(from: Int, to: Int): List[Int] =
  for (i <- List.range(from, to) if i % 2 == 0) yield i
  
  println(event(0, 30))
  // List(0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28)
  ```
  </br>
  
  * 또 다른 예제
  ```scala
  val fruits = List("apple", "banana", "orange")

  val names: List[String] = for (e <- fruits) yield  e.toUpperCase
  println(names)
  // List(APPLE, BANANA, ORANGE)

  val lengths: List[Int] = for (e <- fruits) yield  e.length
  println(lengths)
  // List(5, 6, 6)
  ```
  </br>
  
  * 간단한 변환 작업에는 ```map``` 함수가 더 유용한 듯
  ```scala
  val fruits = List("apple", "banana", "orange")
  println(fruits.map(_.toUpperCase))
  // List(APPLE, BANANA, ORANGE)
  ```
  </br>
  
  * 아래와 같이 복잡도가 높아질수록 ```for/yield```를 사용한 코드가 이해하기 쉽다
  ```scala
  val fruits = List("apple", "banana", "orange")
  println(fruits.map(_.substring(0, 1)).map(_.toUpperCase))

  val result = for {
    e <- fruits
  } yield {
    e.substring(0, 1).toUpperCase
  }

  println(result)  
  ```
