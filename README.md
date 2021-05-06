# common-scala-impl

## 介绍
参考Apache common包的Scala实现

## 使用说明
### StringUtils
#### Scala
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
#### Java
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