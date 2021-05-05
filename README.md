# common-scala-impl

## 介绍
参考Apache common包的Scala实现

## 使用说明
### StringUtils
#### Scala
在Scala中，common-scala-impl通过隐式转换的方式提供String对象的增强方法
在代码中，通过
```scala
import cn.yuc.scala.common.StringImplicitClasses._
```
即可为字符串`String`或字符串数组`Array[String]`类型提供StringUtils中的增强方法，如：
```scala
import cn.yuc.common.StringImplicitClasses._
"   ".isBlank
"123".isNumeric
Array(" ","123","abc").isAnyBlank
```
等等
#### Java
在Java中，通过`import cn.yuc.scala.common.StringUtils`调用其中的静态方法即可
```java
StringUtils.isWhiteSpace("  ")
StringUtils.isBlank("  ")
// ...
```