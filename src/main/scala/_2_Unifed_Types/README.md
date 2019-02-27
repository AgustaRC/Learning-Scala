# 스칼라의 클래스 계층구조 다이어그램
<img src="https://github.com/AgustaRC/Learning-Scala/blob/master/src/main/scala/_2_Unifed_Types/unified-types-diagram.png"/>
</br>

* 스칼라는 최상위 클래스로 ```Any```가 있다.

* ```Any```는 ```equals```, ```hashCode```, ```toString```과 같은 보편적인 메소드를 정의한다.

* ```Any```는 AnyVal과 AnyRef라는 두 서브 클래스로 파생됨
  * ```AnyVal``` : 값 클래스, Java에서 primitive 타입의 Wrapper class 같은 놈들
  * ```AnyRef``` : 레퍼런스 형 클래스

* 모든 사용자 정의 클래스는 자동으로 레퍼런스 형 타입으로 정의되며, ```AnyRef```의 서브 클래스다.

* 스칼라가 Java 런타임 환경 측면에서 보면 ```java.lang.Object```에 해당한다. 

```scala
val list: List[Any] = List(
  "a string", // AnyRef
  732,  // AnyVal
  'c',  // AnyVal
  true, // AnyVal
  () => "an anonymous function returning a string"  // AnyRef
)

list.foreach(element => println(element))
```
Any 타입을 가지는 List를 선언한 후  문자열, 숫자, 캐릭터, 불리언 값과 심지어 익명 함수까지 집어넣은 뒤 출력하면 아래와 같은 결과가 나온다.
```
a string
732
c
true
_2_Unifed_Types.Exercise1$$$Lambda$5/984849465@23223dd8
```

</br>

# 스칼라 타입 캐스팅
<img src="https://github.com/AgustaRC/Learning-Scala/blob/master/src/main/scala/_2_Unifed_Types/type-casting-diagram.png"/>
</br>

* 스칼라는 위와 같은 타입 캐스팅 구조를 가지고 있다.

* 단방향으로만 타입 캐스팅이 가능

```scala
val x: Long = 987654321
val y: Float = x  // 9.8765434E8 (note that some precision is lost in this case)
val face: Char = '☺'
val number: Int = face  // 9786
```
* 아래는 컴파일 안됨
```scala
val x: Long = 987654321
val y: Float = x  // 9.8765434E8
val z: Long = y  // Does not conform
```
* 레퍼런스 타입의 캐스팅은 별도의 섹션에서 알아보자.
</br>

# Nothing, Null & null, Nil, None
* Nothing
  * Trait이며 모든 것들의 서브타입
  * 값을 가지지 않는다.
  * 일반적인 용도는 무한 루프나 예외를 throw를 하는 함수같이, 실질적으로 값을 리턴하지 못하는 함수의 리턴 타입으로도 사용된다
</br>

* Null & null
  * null은 Java의 null과 동일
  * Null은 null이라는 값을 가진 trait
  * 타입 매개변수를 제약하는데 사용됨
</br>

* Nil
  * 엘리먼트가 하나도 없는 리스트
  ```scala
  val list: List[Nothing] = List()
  assert(list == Nil)
  ```
</br>

* None
  * NPE를 피하기 위한 Option 래퍼
  ```scala
  val opt: Option[String] = None
  ```
  * Option에는 Some과 None이라는 하위 클래스가 있음.
  ```scala
  final case class Some[+A](value: A) extends Option[A] {
  ```
