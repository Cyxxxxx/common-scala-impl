# common-scala-impl
Scala implementation modeled Apache common
## Description
### Scala
In Scala, you can use common-scala-impl by `import cn.yuc.common._`
### Java
In Java,  you can use common-scala-impl by `import cn.yuc.common.japi.*;`
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

## ArrayUtils
### Scala
In Scala, `Array` comes with `toList` and `toBuffer`, but `ArrayUtils` provides more clear functions
```scala
import cn.yuc.common.ArrayUtils
val arr = Array(1,2,3)
ArrayUtils.asImmutableList(arr) // equivalent to arr.toList，but it more clear that the array will be transformed into immutable list
ArrayUtils.asListBuffer(arr) // transform Array to ListBuffer, instead of Buffer
ArrayUtils.asJavaMutableList(arr) // transform Array to java.util.List
```
### Java
In Java, people always transform `Array` to `List` by using `Arrays.asList(arr)`, but `Arrays.asList(arr)` return an immutable `List`
```java
import cn.yuc.common.japi.ArrayUtils;
class Test {
    public static void main(String[] args) {
        String[] strings = {"a","b","c"};
        System.out.println(ArrayUtils.asMutableList(strings));
        System.out.println(ArrayUtils.asImmutableList(strings));
        ArrayUtils.asMutableList(strings).add("d");
        ArrayUtils.asImmutableList(strings).add("d"); // throw java.lang.UnsupportedOperationException
    }
}
```