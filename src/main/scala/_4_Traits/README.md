# trait
* Java8의 ```interface```나 Kotlin의 ```interface```와 비슷함
* ```class```와 ```object```는 ```trait```을 ```extends``` 할 수 있음
* ```trait```은 생성자를 가질 수 없고 구체화될 수 없다
* ```trait```은 멤버와 메소드 구현을 가질 수 있다
</br>

# trait 선언
* 추상 메소드와 제네릭 타입을 가지는 ```trait``` 선언
```scala
trait Iterator[T] {
  def hasNext: Boolean
  def next(): T
}
```
* ```trait```을 구현하는 ```class```는 ```trait```에 정의된 추상 메소드를 구현해야 한다
```scala
class IntIterator(to: Int) extends Iterator[Int] {
  private var current = 0

  override def hasNext: Boolean = current < to

  override def next(): Int = {
    if (hasNext) {
      val t = current
      current += 1
      t
    } else 0
  }
}
```
* Java, Kotlin과 마찬가지로 구현할 메소드에 ```override``` 키워드를 붙여준다
* ```trait```의 추상 메소드가 구현을 포함한다면 ```override```는 필수지만 그게 아니면 필수는 아닌 듯
</br>

# 서브타이핑
* Java나 Kotlin과 크게 다른 점이 없는 듯
```scala
trait Pet {
  val name: String
}

class Cat(val name: String) extends Pet
class Dog(val name: String) extends Pet

val cat = new Cat("Sally")
val dog = new Dog("Harry")

val animals = ArrayBuffer.empty[Pet]
animals.append(cat)
animals.append(dog)
animals.foreach(pet => println(pet.name))
```
