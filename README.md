# common-scala-impl
参考apache-commons-lang或spring-framework-bean中一些Utils的Scala实现
## 使用说明
### Scala
在Scala中，`import cn.yuc.common._` 即可使用common包下的所有utils
### Java
在Java中，`import cn.yuc.common.japi.*;` 即可使用common包下的所有utils

## Asserts
`Asserts`包装了断言`assert`的相关操作
```scala
import cn.yuc.common.Asserts
val obj = ""
Asserts.notNull(obj,"若对象为空，抛出Error并提示该条错误消息")
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
## BeanUtils
在Spring中，人们常用org.springframework.beans.BeanUtils.copyProperties(source,target)来对POJO的属性进行复制
common-scala-impl以scala提供上述方法的实现，并提供更易用的隐式转换函数和工具函数
### Scala
在Scala中，可通过
```scala
import cn.yuc.common.BeanUtils.RichBean
def test(b1: cn.yuc.common.entity.Bean1): cn.yuc.common.entity.Bean2 = b1.to[cn.yuc.common.entity.Bean2]
```
或者
```scala
import cn.yuc.common.BeanUtils
def test(b1: cn.yuc.common.entity.Bean1): cn.yuc.common.entity.Bean2 = BeanUtils.transform[cn.yuc.common.entity.Bean2](b1)
```
等价于
```scala
import cn.yuc.common.BeanUtils
def test(b1: cn.yuc.common.entity.Bean1): cn.yuc.common.entity.Bean2 = {
  val b2 = new cn.yuc.common.entity.Bean2()
  BeanUtils.copyProperties(b1,b2)
  b2
}
```

### Java
在Java中：
```java
import cn.yuc.common.entity.Bean2;
import cn.yuc.common.japi.BeanUtils;

class Test {
    public void test(Bean1 bean1) {
        Bean2 bean2 = BeanUtils.transform(bean1, Bean2.class);
        // 或者
        Bean2 bean21 = new Bean2();
        BeanUtils.copyProperties(bean1,bean21);
    }
}
```

## ClassUtils
`ClassUtils`提供了一些对Class对象进行操作或检查的函数，帮助人们更好地使用Java反射API，详见注释

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

