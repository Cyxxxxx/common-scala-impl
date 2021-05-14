package cn.yuc.common
package eval


object Test {

  def main(args: Array[String]): Unit = {
    import enhance.PredefEnhancer._
    // usage1: eval with expression
    println(eval("2+2")) // output: 4

    // usage2: eval with creation of object
    val list = eval("List(1,2,3)")
    println(list) // output: List(1,2,3)
    println(list.asInstanceOf[List[_]](1)) // output: 2

    // usage3: eval with anonymous function string
    val fun = eval("""(str:String) => println(str.replaceAll("-",","))""").asInstanceOf[String=>Unit]
    fun("common-scala-impl") // output: common,scala,impl

  }


}
