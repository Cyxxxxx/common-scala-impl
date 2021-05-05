# common-scala-impl
Scala implementation modeled Apache common

## StringUtils
### Scala
In Scala，common-scala-impl provides utils function for String through implicit
```scala
import cn.yuc.scala.common.StringImplicitClasses._
```
After you import the implicit class, you can use the utils function on `String` or `Array[String]` object, for example:
```scala
import cn.yuc.scala.common.StringImplicitClasses._
"   ".isBlank
"123".isNumeric
Array(" ","123","abc").isAnyBlank
```
etc...

You can also use common-scala-impl in Scala like use Apache common in Java code
```scala
import cn.yuc.scala.common.StringUtils
StringUtils.isBlank("  ")
StringUtils.isNumeric("123")
```
### Java
In Java, use common-scala-impl like Apache common:
```java
import cn.yuc.scala.common.StringUtils;
class Test {
    public static void main(String[] args) {
        StringUtils.isWhiteSpace("  ");
        StringUtils.isBlank("  ");
        // ...
    }
}
```