# common-scala-impl
Scala implementation modeled some utils of {apache-commons-lang, spring-framework-bean}
## Description
### Scala
In Scala, you can use common-scala-impl by `import cn.yuc.common._`
### Java
In Java,  you can use common-scala-impl by `import cn.yuc.common.japi.*;`

## Asserts
`Asserts` warp assertion operations up
```scala
import cn.yuc.common.Asserts
val obj = ""
Asserts.notNull(obj,"if obj is null,throw error and show this error message")
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

## BeanUtils
In Spring，people always using org.springframework.beans.BeanUtils.copyProperties(source,target) to copy bean's field from source to target
common-scala-impl Provide the implementation of the above method in scala，and provide easier implicit or utils functions
### Scala
In Scala, you can conveniently copy properties from source to target type like that: 
```scala
import cn.yuc.common.BeanUtils.RichBean
def test(b1: cn.yuc.common.entity.Bean1): cn.yuc.common.entity.Bean2 = b1.to[cn.yuc.common.entity.Bean2]
```
or
```scala
import cn.yuc.common.BeanUtils
def test(b1: cn.yuc.common.entity.Bean1): cn.yuc.common.entity.Bean2 = BeanUtils.transform[cn.yuc.common.entity.Bean2](b1)
```
equivalent to
```scala
import cn.yuc.common.BeanUtils
def test(b1: cn.yuc.common.entity.Bean1): cn.yuc.common.entity.Bean2 = {
  val b2 = new cn.yuc.common.entity.Bean2()
  BeanUtils.copyProperties(b1,b2)
  b2
}
```

### Java
In Java: 
```java
import cn.yuc.common.entity.Bean2;
import cn.yuc.common.japi.BeanUtils;

class Test {
    public void test(Bean1 bean1) {
        Bean2 bean2 = BeanUtils.transform(bean1, Bean2.class);
        // or
        Bean2 bean21 = new Bean2();
        BeanUtils.copyProperties(bean1,bean21);
    }
}
```

## ClassUtils
`Class Utils` provides some functions for operating or checking Class objects to help people better use the Java reflection API, see the notes in code for details

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

