# 믹스인 클래스 컴포지션
* 단일 상속만을 제공하는 Java와는 달리 스칼라는 ```trait```과 ```with``` 키워드를 통해 다중 상속 비슷하게 동작
* Mixin을 적용하기 위해선 ```class```가 아닌 ```trait```만 가능
```scala
abstract class A {
  val message: String
}

class B extends A {
  val message = "I'm an instance of class B"
}

trait C extends A {
  def loudMessage: String = message.toUpperCase()
}

class D extends B with C

val d = new D
println(d.message) // I'm an instance of class B
println(d.loudMessage) // I'M AN INSTANCE OF CLASS B
```
</br>

* with 키워드를 이용해서 여러 개의 trait도 선언 가능
```scala
abstract class A {
  val message: String = "A"
}

trait B extends A {
  override val message: String = "B"
}

trait C extends A {
  override val message: String = "C"
}

class E extends A with B with C

val e = new E
println(e.message)
```
* Q : ```class A```에 선언된 ```message```라는 변수를 ```trait``` ```B``` 및 ```C```에서 ```override``` 하고 ```class E```는 ```A```를 상속받고 ```B```와 ```C```를 Mixin 시켰다. 이럴 때 최종 ```message```는 무엇이 될까?
* A : ```C```, ```class``` 선언 상 마지막 위치에 있는 것으로 ```override```
* ```with```으로 선언된 ```trait```의 구현 내용을 자식 클래스 내부에 ```inlining``` 시킴
</br>

```scala
abstract class AbsIterator {
  type T

  def hasNext: Boolean

  def next: T
}

class StringIterator(s: String) extends AbsIterator {
  type T = Char
  private var i = 0

  override def hasNext: Boolean = i < s.length

  override def next: Char = {
    val ch = s charAt i
    i += 1
    ch
  }
}

trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit): Unit = while (hasNext) f(next)
}

class RichStringIterator(s: String) extends StringIterator(s) with RichIterator

val iterator = new RichStringIterator("Leopold")
iterator foreach println
```
* 위와 같이 내부 구현을 갖고 있는 ```StringIterator```와 ```RichIterator```를 합쳐 새로운 ```class```를 만들고자 할 때 사용 
* 조금 더 디테일한 세부 사항은 실제 구현된 코드 등을 자주 보면서 익히자
