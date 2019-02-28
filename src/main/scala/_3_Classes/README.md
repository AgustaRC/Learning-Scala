# 클래스 선언
* 클래스 선언은 ```class``` 키워드와 함께
* 클래스는 기본적으로 디폴트 생성자를 포함한다.
* 클래스 생성 시 생성자의 파라미터 유무에 따라 ```()``` 생략 가능
```scala
val user1 = new User
val user2 = new User()
class User
```
* 클래스 생성자의 파라미터에 기본 값을 설정할 수 있다.
```scala
val person1 = new Person()
val person2 = new Person(name = "Leopold")
class Person(name: String = "default")
```
* Kotlin에도 제공되는 기능인데 동일 타입의 파라미터가 여러 개일 경우 개발자의 실수를 줄일 수 있어서 좋은 듯.
* ```person1```은 ```name```이 "default"로 설정되고 ```person2```는 "Leopold"로 설정됨
* 파라미터가 있는 생성자의 경우 인스턴스 생성 시 ```()``` 생략이 불가능
* 기본적인 클래스 형태
```scala
class Point(var x: Int, var y: Int) {

  def move(dx: Int, dy: Int): Unit = {
    x += dx
    y += dy
  }

  override def toString: String = s"($x, $y)"
}
```
* ```s"($x, $y)"```는 Kotlin에서도 제공하는 문자열 템플릿
</br>

# 클래스 생성자
* 생성자의 파라미터에 기본 값을 설정할 수 있는데 클래스 생성 시 Named arguments를 설정할 수 있다.
* Kotlin에서도 제공
* 참고로 Java랑 호환은 안됨
* Java에서 Kotlin의 ```data class```를 생성할 때 동일 타입의 파라미터가 연속적으로 있을 경우 조심..
```scala
class Point(var x: Int = 0, var y: Int = 0)

var point = new Point()
print(point) // (x : 0, y : 0)
point = new Point(x = 10)
print(point) // (x : 10, y : 0)
point = new Point(y = 10)
print(point) // (x : 0, y : 10)
point = new Point(y = 10, x = 20)
print(point) // (x : 20, y : 10)
```
* 인자의 이름을 지정하지 않으면 순서대로 적용
* 인자의 이름을 지정하면 순서를 바꿀 수 있음
</br>

# Private 멤버 및 Getter/Setter
* private 멤버 선언은 Java나 Kotlin이랑 동일
* Getter / Setter 방식은 Kotlin과 비슷
```scala
class Point {
  private var _x = 0
  private var _y = 0
  private val bound = 100

  def x: Int = _x // Getter
  def x_= (newValue: Int): Unit = { // Setter
    if (newValue < bound) _x = newValue else printWarning()
  }

  def y: Int = _y
  def y_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning()
  }

  def z: Int = _y
  def z_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning()
  }

  private def printWarning(): Unit = println("WARNING: Out of bounds")
}
```
* 테스트해보니 멤버와 Getter와 Setter는 이름이 동일해야 한다. Setter는 뒤에 ```_=```가 붙음.
* 멤버가 ```val```인 경우 Setter 정의 불가능. 당연한 소리겠지만...
```scala
class Point(val x: Int, val y: Int) // x,y public
```
* Primary 생성자 파라미터의 기본 가시성은 ```public```
* 만약 Primary 생성자 파라미터가 ```var``` or ```val```가 아닌 경우 가시성은 ```private```
```scala
class Point(x: Int, y: Int) // x,y private
```
* 또는 명시적으로 ```private```으로 선언할 수 있음
```scala
class Point(private val x: Int, private val y: Int) // x,y private
```
