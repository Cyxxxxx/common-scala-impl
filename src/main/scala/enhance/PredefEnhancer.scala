package cn.yuc.common
package enhance

import enhance.clazz.{RichBean, RichString, RichStringArray}

import scala.reflect.runtime.universe
import scala.reflect.runtime.universe._
import scala.tools.reflect.ToolBox

/**
 * 增强Scala的预定义对象
 * to enhance the scala.Predef
 * @author YuC
 */
object PredefEnhancer {

  val START_INDEX = 0
  val toolbox: ToolBox[universe.type] = runtimeMirror(AnyRef.getClass.getClassLoader).mkToolBox()
  /**
   * 包装类似JavaScript或Python的eval函数
   * use function 'eval(string)' like Python or JavaScript
   * @param code String type scala code
   * @return if code is a expression, return a result
   *         if it's a anonymous function, return a function
   * @see src\test\scala\eval\Test.scala
   */
  def eval(code: String): Any = {
    val tree = toolbox.parse(code)
    toolbox.eval(tree)
  }


  implicit def enhance(predef: Predef.type): PredefEnhancer.type = this


  /**
   * <p>
   * Scala用户专用
   * 在代码中通过import cn.yuc.common.enhance.PredefEnhancer._ 或者 import cn.yuc.common.enhance.PredefEnhancer.stringWrapper
   * 即可使用隐式转换对String对象直接调用相关方法
   *
   * For scala users
   * [import cn.yuc.common.enhance.PredefEnhancer._] or [import cn.yuc.common.enhance.PredefEnhancer.stringWrapper]
   * you can check a String object like that:
   * </p>
   * str.isNull <==> str == null
   * str.isNullOrEmpty <==> StringUtils.isNullOrEmpty(str)
   * !str.isNullOrEmpty <==> StringUtils.isNotNullOrEmpty(str)
   * str.isBlank <==> StringUtils.isBlank(str)
   * etc..
   *
   * @param string String => RichString
   */
  @inline implicit def stringWrapper(string: String): RichString = new RichString(string)

  /**
   * <p>
   * Scala用户专用
   * 在代码中通过import cn.yuc.common.enhance.PredefEnhancer._ 或者 import cn.yuc.common.enhance.PredefEnhancer.stringArrayWrapper
   * 即可使用隐式转换对String对象直接调用相关方法
   *
   * For scala users
   * [import cn.yuc.common.enhance.PredefEnhancer._] or [import cn.yuc.common.enhance.PredefEnhancer.stringArrayWrapper]
   * you can check a String object like that:
   * </p>
   * val strArr = Array("a","b","","d")
   * strArr.isAnyBlank <==> StringUtils.isAnyBlank(strArr)
   * strArr.isNoneBlank <==> StringUtils.isNoneBlank(strArr)
   * etc..
   *
   * @param strArr Array[String] => RichStringArray
   */
  @inline implicit def stringArrayWrapper(strArr: Array[String]): RichStringArray = new RichStringArray(strArr)


  @inline implicit def beanWrapper(obj: Object): RichBean = new RichBean(obj)

}


