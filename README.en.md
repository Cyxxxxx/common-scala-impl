# common-scala-impl
Scala implementation modeled Apache common

## StringUtils
### Scala
In Scala，common-scala-impl provides utils function for String through implicit
```scala
import cn.yuc.common.StringImplicitClasses._
```
After you import the implicit class, you can use the utils function on `String` or `Array[String]` object, for example:
```scala
import cn.yuc.common.StringImplicitClasses._
"   ".isBlank // true
"123".isNumeric // true
Array(" ","123","abc").isAnyBlank // true
```
etc...

You can also use common-scala-impl in Scala like use Apache common in Java code
```scala
import cn.yuc.common.StringUtils
StringUtils.isBlank("  ") // true
StringUtils.isNumeric("123") // true
```
### Java
In Java, use common-scala-impl like Apache common:
```java
import cn.yuc.common.japi.StringUtils;
class Test {
    public static void main(String[] args) {
        StringUtils.isWhiteSpace("  "); // true
        StringUtils.isBlank("  "); // true
        StringUtils.isAnyBlank("a", "b", "c", " "); // true
        // ...
    }
}
```