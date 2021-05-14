package cn.yuc.common
package string

import enhance.PredefEnhancer._

object ScalaTest {
  def main(args: Array[String]): Unit = {
    // f => false, t => true
    println("".isWhiteSpace) // f
    println(StringUtils.isNumeric("123")) // t
    println(StringUtils.isNumeric("123a")) // f
    println(StringUtils.isNumeric("123 ")) // f
    println(StringUtils.isNumericSpace("123 ")) // t
    println(Array("ab").isAnyBlank) // f
    println(Array("").isAnyBlank) // t
    println(Array("ab"," ").isNoneBlank) // f
    println(Array(" ").isNoneBlank) // f
  }
}
