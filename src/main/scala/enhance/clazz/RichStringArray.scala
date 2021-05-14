package cn.yuc.common
package enhance.clazz

import enhance.PredefEnhancer._

import scala.annotation.tailrec


class RichStringArray(strings: Array[String]) {

  def isAnyBlank: Boolean = {
    def strArrIsEmpty: Boolean = {
      strings == null || strings.isEmpty
    }

    strArrIsEmpty || checkForEachStr(_.isBlank)
  }

  def isNoneBlank: Boolean = !isAnyBlank

  /**
   * 使用传入的函数遍历检查字符串序列 / 数组中的所有元素
   * Checks each String Object of a String Seq or String Array
   *
   * @param checkFunction the function u want to check for each String element
   * @param idx index for traverse Seq or Array, saving the current index for tailrec
   * @return if the Seq or Array contains any element u want, return true; else return false.
   */
  @tailrec
  private def checkForEachStr(checkFunction: String => Boolean, idx: Int = START_INDEX): Boolean = {
    if (idx == strings.length) return false
    if (checkFunction.apply(strings(idx))) return true
    checkForEachStr(checkFunction, idx + 1)
  }

}
