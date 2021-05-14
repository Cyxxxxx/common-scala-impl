# common-scala-impl
Scala implementation modeled some utils of {apache-commons-lang, spring-framework-bean}
## Description
### Scala
In Scala, you can use common-scala-impl by `import cn.yuc.common._`
### Java
In Java,  you can use common-scala-impl by `import cn.yuc.common.japi.*;`

## Enhancement function
### eval
use function 'eval(scala code string)' like Python or JavaScript

See src\test\scala\eval\Test.scala

## Utils
### Asserts
`Asserts` warp assertion operations up
```scala
import cn.yuc.common.Asserts
val obj = ""
Asserts.notNull(obj,"if obj is null,throw error and show this error message")
```

### ArrayUtils
#### Scala
In Scala, `Array` comes with `toList` and `toBuffer`, but `ArrayUtils` provides more clear functions
```scala
import cn.yuc.common.ArrayUtils
val arr = Array(1,2,3)
ArrayUtils.asImmutableList(arr) // equivalent to arr.toList，but it more clear that the array will be transformed into immutable list
ArrayUtils.asListBuffer(arr) // transform Array to ListBuffer, instead of Buffer
ArrayUtils.asJavaMutableList(arr) // transform Array to java.util.List
```
See src\test\scala\array\ScalaTest.scala
#### Java
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

See src\test\scala\string\JavaTest.java

### BeanUtils
In Spring，people always using org.springframework.beans.BeanUtils.copyProperties(source,target) to copy bean's field from source to target
common-scala-impl Provide the implementation of the above method in scala，and provide easier implicit or utils functions
#### Scala
See src\test\scala\bean\ScalaTest.scala
#### Java
See src\test\scala\bean\JavaTest.java

### ClassUtils
`Class Utils` provides some functions for operating or checking Class objects to help people better use the Java reflection API, see the notes in code for details

### StringUtils
#### Scala
See src\test\scala\string\ScalaTest.scala
#### Java
In Java, use common-scala-impl like Apache common

See src\test\scala\string\JavaTest.scala

