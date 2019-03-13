# Regular Expression Patterns
* Java에서 정규 표현식과 관련된 클래스가 ```Pattern```, ```Matcher```가 있다면 Scala에서는 ```Regex``` 클래스가 있다.
* 문자열 끝에 ```.r``` 메소드를 호출하면 ```Regex``` 인스턴스를 얻을 수 있다.
* Regex에서는 ```findxxx``` 류의 메소드와 ```replacexxx``` 류의 메소드를 제공
* replace 류의 메소드들은 ```String```을 반환
* ```findFirstIn```, ```findFirstMatchIn```, ```findPrefixOf```, ```findPrefixMatchOf``` 메소드들은 ```Option```을 반환하는데 ```Some``` 또는 ```None```이다. 
  * 매칭된 결과가 있다면 ```Some```에 담겨서 반환되고 매칭된 결과가 없다면 ```None```을 반환
```scala
val pattern: Regex = "[0-9]".r

pattern.findFirstMatchIn("awesomepassword") match {
  case Some(_) => println("Password Ok")
  case None => println("Password must contain a number")
}
```
* 기타 정규 표현식 예제들
```scala
val pattern1 = "(S|s)cala".r
val str1 = "Scala is scalable and cool"
println(pattern1 replaceFirstIn(str1, "Java"))

val pattern2 = """\d+""".r
val str2 = "foo 123 bar 456"
println(pattern2.findAllMatchIn(str2).toList)

val dateNoDay = "2016-08"
val dateWithDay = "2016-08-20"

val YearAndMonth = """(\d{4})-([01][0-9])""".r
val YearMonthAndDay = """(\d{4})-([01][0-9])-([012][0-9])""".r

dateNoDay match {
  case YearAndMonth(_, _) => println("no day provided")
  case YearMonthAndDay(_, _, day) => println(s"day provided: it is $day")
}

dateWithDay match {
  case YearAndMonth(_, _) => println("no day provided")
  case YearMonthAndDay(_, _, day) => println(s"day provided: it is $day")
}

val Pattern = """^(?:foo|bar)\.baz""".r
"""foo.baz""" match {
  case Pattern() => println("ok")
  case _ => println("bleh")
}
```

* 지원하는 정규식 연산자
  * ```.``` : 개행 문자를 제외한 모든 단일 문자와 일치
  * ```$``` : 줄 끝과 일치
  * ```^``` : 줄의 시작과 일치
  * ```[...]``` : 대괄호 안에 있는 단일 문자와 일치
  * ```[^...]``` : 대괄호 안에 있는 문자를 제외한 모든 단일 문자와 일치
  * ```re*``` : 선행 표현의 0 번 또는 그 이상 일치
  * ```re+``` : 선행 표현의 1 또는 그 이상 일치
  * ```re?``` : 선행 표현의 0 또는 1 발생과 일치
  * ```re{n}``` : 선행 표현의 정확히 n 번 일치
  * ```re{n,}``` : 선행 표현식이 n 회 이상 일치
  * ```re{n, m}``` : 선행 표현의 n 번 이상 m 번 일치
  * ```a | b``` : a 또는 b와 일치
  * ```(re)``` : 정규 표현식을 그룹화하고 일치하는 텍스트를 기억한다.
  * ```(?:re)``` : 일치하는 텍스트를 기억하지 않고 정규식을 그룹화한다.
  * ```(?>re)``` : 백 트래킹 없이 독립적인 패턴과 일치
  * ```\\w``` : 단어 문자와 일치
  * ```\\W``` : 단어가 아닌 문자와 일치
  * ```\\s``` : 공백과 일치 [\t \n \r \f]와 동일
  * ```\\S``` : 비공백 문자와 일치
  * ```\\d``` : 숫자와 일치. [0-9]와 동일
  * ```\\D``` : 숫자가 아닌 문자와 일치
  * ```\\A``` : 문자열 시작 부분과 일치
  * ```\\Z``` : 문자열의 끝과 일치. 개행 문자가 있으면 개행 직전과 일치
  * ```\\z``` : 문자열의 끝과 일치
  * ```\\G``` : 마지막 매칭이 끝난 지점
  * ```\\n``` : 캡처 그룹 번호 "n"에 대한 역 참조
  * ```\\b``` : 바깥 괄호가 있을 때 단어 경계
  * ```\\B``` : 단어 경계과 일치
 
