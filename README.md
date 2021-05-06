# common-scala-impl
参考Apache common包的Scala实现
## 使用说明
### Scala
在Scala中，`import cn.yuc.common._` 即可使用common包下的所有utils
### Java
在Java中，`import cn.yuc.common.japi.*;` 即可使用common包下的所有utils
## StringUtils
### Scala
在Scala中，common-scala-impl通过隐式转换的方式提供String对象的增强方法
在代码中，通过
```scala
import cn.yuc.common.StringImplicitClasses._
```
即可为字符串`String`或字符串数组`Array[String]`类型提供StringUtils中的增强方法，如：
```scala
import cn.yuc.common.StringImplicitClasses._
"   ".isBlank // true
"123".isNumeric // true
Array(" ","123","abc").isAnyBlank // true
```
等等...

你也可以像在Java代码中使用Apache common一般使用common-scala-impl：
```scala
import cn.yuc.common.StringUtils
StringUtils.isBlank("  ") // true
StringUtils.isNumeric("123") // true
```
### Java
在Java中，通过`import cn.yuc.common.japi.StringUtils`调用其中的静态方法即可
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
在Scala中的`Array`自带了`toList`和`toBuffer`函数，但`ArrayUtils`提供了更为明确的函数
```scala
import cn.yuc.common.ArrayUtils
val arr = Array(1,2,3)
ArrayUtils.asImmutableList(arr) // 等价于 arr.toList，但更明确数组能够转化为不可变列表
ArrayUtils.asListBuffer(arr) // 将 Array 转化为 ListBuffer 而非 Buffer
ArrayUtils.asJavaMutableList(arr) // 将 Array 转化为 java.util.List
```
### Java
在Java中，人们常用`Arrays.asList(arr)`将`Array`转化为`List`，但是该`List`并不可变（immutable）
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