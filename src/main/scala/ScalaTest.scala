package cn.yuc.scala.common
import cn.yuc.scala.common.StringImplicitClasses._

object ScalaTest {

  def main(args: Array[String]): Unit = {
//    println("".isWhiteSpace)
//    println(StringUtils.isNumeric("123"))
//    println(StringUtils.isNumeric("123a"))
//    println(StringUtils.isNumeric("123 "))
    println(Array("ab").isAnyBlank)
    println(Array("").isAnyBlank)
    println(Array("ab"," ").isNoneBlank)
    println(Array(" ").isNoneBlank)
  }

  def test(str: String): Unit = println(str.isNull)
}
