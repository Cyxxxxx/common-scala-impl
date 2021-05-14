# common-scala-impl
参考apache-commons-lang或spring-framework-bean中一些Utils的Scala实现
## 使用说明
### Scala
在Scala中，`import cn.yuc.common._` 即可使用common包下的所有utils
### Java
在Java中，`import cn.yuc.common.japi.*;` 即可使用common包下的所有utils

## 增强函数
### eval
common-scala-impl封装了eval函数，可动态执行一些String类型的Scala代码

详见src\test\scala\eval\Test.scala
## 工具类
### Asserts
`Asserts`包装了断言`assert`的相关操作
```scala
import cn.yuc.common.Asserts
val obj = ""
Asserts.notNull(obj,"若对象为空，抛出Error并提示该条错误消息")
```

### ArrayUtils
#### Scala
在Scala中的`Array`自带了`toList`和`toBuffer`函数，但`ArrayUtils`提供了更为明确的函数
```scala
import cn.yuc.common.ArrayUtils
val arr = Array(1,2,3)
ArrayUtils.asImmutableList(arr) // 等价于 arr.toList，但更明确数组能够转化为不可变列表
ArrayUtils.asListBuffer(arr) // 将 Array 转化为 ListBuffer 而非 Buffer
ArrayUtils.asJavaMutableList(arr) // 将 Array 转化为 java.util.List
```
详见src\test\scala\array\ScalaTest.scala
#### Java
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
详见src\test\scala\string\JavaTest.java
### BeanUtils
在Spring中，人们常用org.springframework.beans.BeanUtils.copyProperties(source,target)来对POJO的属性进行复制

common-scala-impl以scala提供上述方法的实现，并提供更易用的隐式转换函数和工具函数
#### Scala
详见src\test\scala\bean\ScalaTest.scala

#### Java
详见src\test\scala\bean\JavaTest.java


### ClassUtils
`ClassUtils`提供了一些对Class对象进行操作或检查的函数，帮助人们更好地使用Java反射API，详见注释

### StringUtils
#### Scala
详见src\test\scala\string\ScalaTest.scala
#### Java
在Java中，通过`import cn.yuc.common.japi.StringUtils`调用其中的静态方法即可

详见src\test\scala\string\JavaTest.scala

