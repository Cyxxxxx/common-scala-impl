package cn.yuc.common
package bean


object ScalaTest {
  def main(args: Array[String]): Unit = {
    import enhance.PredefEnhancer.beanWrapper

    val newObj = TestObj1(1, "2").to[TestObj2]
    println(s"i: ${newObj.i}, s: ${newObj.s}") // i: 1, s: 2

    val newObj2 = TestObj1(3, "4").to[TestObj3]
    println(s"i: ${newObj2.i}, s: ${newObj2.s}") // i: 3, s: 4

    //    val newObj3 = TestObj1(5, "6").to[TestObj4]
    val newObj3 = BeanUtils.transform[TestObj4](TestObj1(5, "6"))
    println(s"i: ${newObj3.i}, s: ${newObj3.s}") // i: 5, s: 6
  }
}

case class TestObj1(i:Int,s:String)
case class TestObj2(i:Int,s:String)
case class TestObj3(i:Int,s:String)
case class TestObj4(i:Int,s:String)