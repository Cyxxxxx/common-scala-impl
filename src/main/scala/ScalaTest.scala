package cn.yuc.common
import StringImplicitClasses._


object ScalaTest {

  def main(args: Array[String]): Unit = {
//    println("".isWhiteSpace)
//    println(StringUtils.isNumeric("123"))
//    println(StringUtils.isNumeric("123a"))
//    println(StringUtils.isNumeric("123 "))
//    println(Array("ab").isAnyBlank)
//    println(Array("").isAnyBlank)
//    println(Array("ab"," ").isNoneBlank)
//    println(Array(" ").isNoneBlank)

    val arr = Array(123,456,789)
    println(ArrayUtils.asImmutableList(arr).getClass)
    ArrayUtils.asImmutableList(arr).foreach(println)
    println(ArrayUtils.asListBuffer(arr).getClass)
    ArrayUtils.asListBuffer(arr).foreach(println)
    val javaMutableList = ArrayUtils.asJavaMutableList(arr)
    println(javaMutableList.getClass)
    for(i <- 0 until javaMutableList.size()){
      println(javaMutableList.get(i))
    }
  }

  def test(str: String): Unit = println(str.isNull)

}
