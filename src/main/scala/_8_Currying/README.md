# 커링 (Currying)
* 여러 개의 인자를 갖는 함수 형태를 단일 인자를 갖는 함수 여러 개의 형태로 표현하는 것
* 장점
  * 함수의 재활용을 용이하게 해준다. (특정 값을 고정시킨 채)
  * 함수의 실행을 마지막 인자가 주어질 때까지 뒤로 미룰 수 있다.
  * 함수의 파라미터를 원하는 만큼 가질 수 있다.
</br>

* Currying 예제 코드
```scala
def filter(xs: List[Int], p: Int => Boolean): List[Int] =
  if (xs.isEmpty) xs
  else if (p(xs.head)) xs.head :: filter(xs.tail, p)
  else filter(xs.tail, p)

def modN(n: Int)(x: Int): Boolean = (x % n) == 0

val list = List(1, 2, 3, 4, 5, 6, 7, 8)
println(filter(list, modN(2))) // 2, 4, 6, 8
println(filter(list, modN(3))) // 3, 6
```
</br>

* 아래와 같은 테스트 코드를 실행해보면 함수의 실행을 마지막 인자가 주어질 때까지 미룰 수 있다는 것을 확인할 수 있다.
```scala
def curry(s1: String)(s2: String)(s3: String): String = {
  println("curry")
  s1 + s2 + s3
}

val a = curry("s1")_
println(a)

val b = a("s2")
println(b)

val c = b("s3")
println(c)
```
</br>

* 아래처럼 함수를 재사용할 수 있다.
```scala
def account(website: String): String => String => String = (id: String) => (password: String) =>
  "Website : %s, Id : %s, Password : %s".format(website, id, password)
    
val naver = account("Naver")

val baik = naver("Baik")
val leopold = naver("Leopold")

println(baik("1111"))
println(leopold("2222"))
```
</br>

# 더 알아볼 것
  * 언커링 (Uncurrying) : [Currying and Uncurrying in JavaScript and Flow](https://medium.com/@JosephJnk/currying-and-uncurrying-in-javascript-and-flow-98877c8274ff)
  * 부분 적용 함수, 부분 함수 : [Scala의 partially applied function과 partial function 이해하기](https://blog.outsider.ne.kr/953)
