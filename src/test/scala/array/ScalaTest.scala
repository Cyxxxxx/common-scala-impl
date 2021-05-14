package cn.yuc.common
package array

object ScalaTest {
  def main(args: Array[String]): Unit = {
    val arr = Array(123,456,789)
    // immutable list
    println(ArrayUtils.asImmutableList(arr).getClass) // class scala.collection.immutable.$colon$colon
    ArrayUtils.asImmutableList(arr).foreach(println)


    // mutable list: list buffer
    println(ArrayUtils.asListBuffer(arr).getClass) // class scala.collection.mutable.ListBuffer
    ArrayUtils.asListBuffer(arr).foreach(println)

    // mutable list: java mutable list
    val javaMutableList = ArrayUtils.asJavaMutableList(arr)
    println(javaMutableList.getClass) // class scala.collection.convert.Wrappers$MutableBufferWrapper
    for(i <- 0 until javaMutableList.size()){
      println(javaMutableList.get(i))
    }
  }
}
