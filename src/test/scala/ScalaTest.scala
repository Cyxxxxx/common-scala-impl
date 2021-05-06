package cn.yuc.common

import BeanUtils.RichBean
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

//    val arr = Array(123,456,789)
//    println(ArrayUtils.asImmutableList(arr).getClass)
//    ArrayUtils.asImmutableList(arr).foreach(println)
//    println(ArrayUtils.asListBuffer(arr).getClass)
//    ArrayUtils.asListBuffer(arr).foreach(println)
//    val javaMutableList = ArrayUtils.asJavaMutableList(arr)
//    println(javaMutableList.getClass)
//    for(i <- 0 until javaMutableList.size()){
//      println(javaMutableList.get(i))
//    }
    val newObj = TestObj1(1, "2").to[TestObj2]
    println(s"i: ${newObj.i}, s: ${newObj.s}")
    val newObj2 = TestObj1(3, "4").to[TestObj3]
    println(s"i: ${newObj2.i}, s: ${newObj2.s}")
//    val newObj3 = TestObj1(5, "6").to[TestObj4]
    val newObj3 = BeanUtils.transform[TestObj4](TestObj1(5, "6"))
    println(s"i: ${newObj3.i}, s: ${newObj3.s}")

  }

  def test(str: String): Unit = println(str.isNull)

}

case class TestObj1(i:Int=0,s:String="")
case class TestObj2(){
  var i:Int = _
  var s:String = _
}
case class TestObj3(i:Int=0,s:String="")
case class TestObj4(i:Int,s:String,c:Character)