# Higher-order Function (고차 함수)
* 고차 함수란?
  * 함수의 파라미터로 다른 함수를 받거나
  * 함수의 반환 타입으로 함수를 반환하는 것
</br>

* 함수의 파라미터로 다른 함수를 받는 코드
```scala
class Decorator(left: String, right: String) {
  def layout[T] (x: T): String = left + x.toString + right
}

def apply(f: Int => String, v: Int) = f(v)

val decorator = new Decorator("[", "]")
println(apply(decorator.layout, 7)) // [7]
```
</br>

* 함수의 반환 타입으로 함수를 반환하는 코드
```scala
def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
  val schema = if (ssl) "https://" else "http://"
  (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
}

def getURL: (String, String) => String = urlBuilder(ssl=true, "www.example.com")

val endpoint = "users"
val query = "id=1"
val url = getURL(endpoint, query)
println(url) // "https://www.example.com/users?id=1": String
```
</br>

* 기타 고차 함수 샘플 코드 (시간 날 때마다 추가해보자)
```scala
def HTMLStringDecorator(text: String, f: String => String): String = f(text)

def titleTag(data: String): String => String = {
  _: String => s"<title>$data</title>"
}

val message = "Hello"

println(HTMLStringDecorator(
  message,
  titleTag(message)
))
```
</br>

```scala
def forEach(a: Array[String], f:String => Unit): Unit = for (e <- a) f(e)

def remindPayment(x: String): Unit = println("Payment reminder for " + x)

val customers = Array("Mike", "Zara", "Peter")
customers foreach remindPayment
```
