# Singleton Objects
* **특징**
  * 스칼라에선 ```object``` 키워드로 선언하면 Singleton으로 생성된다.
  * ```new``` 키워드를 이용하여 인스턴스 초기화를 할 수 없다.
  * 생성자 파라미터를 정의할 수 없다.
  * 1급 객체이다.
  * 타입을 정의하지 않는다.
  * ```class```를 ```extend``` 하고 ```trait```을 믹스인(mixin) 할 수 있다.
  </br>
  
  ```scala
  object SmartPhone extends Phone with Computer {
    def deviceNumber(): String = "S1989902002"
  }

  trait Computer
  class Phone

  println(SmartPhone.isInstanceOf[Phone])
  println(SmartPhone.isInstanceOf[Computer])
  println(SmartPhone.deviceNumber())
  ```
</br>

* **Standalone Object (독립 객체)**
  * 동반 클래스 (Companion Class)가 없는 싱글톤 클래스
  * 유틸리티 메소드를 모아두기 용이
</br>

* **Companion Class (동반 클래스)**
  * 클래스의 이름이 같은 파일에 선언된 ```object```와 동일한 클래스
</br>

* **Companion Object (동반 객체)**
  * ```object```의 이름이 같은 파일에 선언된 클래스의 이름과 같음
  * Kotlin의 ```companion object```와는 약간 차이가 있다
  * Scala에선 Companion Class와 Companion Object의 이름이 **동일**해야 함
  * 팩토리 메소드 제작하기 용이
  </br>
  
  ```scala
  class Person(name: String) {
    def greeting(): Unit = println(s"$name, Hi")
  }

  object Person {
    def apply(name: String): Person = new Person(name)
  }
  
  val person = Person.apply("Leopold")
  person.greeting()
  ```
