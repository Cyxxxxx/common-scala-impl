package cn.yuc.common
package enhance.clazz

import enhance.PredefEnhancer._

import scala.annotation.tailrec



class RichString(str: String) {

  def isNull: Boolean = str == null

  def isNotNull: Boolean = !this.isNull

  def isNullOrEmpty: Boolean = this.isNull || str.isEmpty

  def isNotNullOrEmpty: Boolean = !this.isNullOrEmpty

  def isBlank: Boolean = this.isNullOrEmpty || this.noneCharacter(!Character.isWhitespace(_))

  def isNumeric: Boolean = this.isNotNullOrEmpty && this.noneCharacter(!Character.isDigit(_))

  def isNumericSpace: Boolean = this.isNotNullOrEmpty && this.noneCharacter(c => !Character.isWhitespace(c) && !Character.isDigit(c))

  def isWhiteSpace: Boolean = this.isNotNullOrEmpty && this.noneCharacter(!Character.isWhitespace(_))

  /**
   * 使用传入的函数遍历检查字符串序列 / 数组中的所有元素，可确保字符串中存在函数指定的字符
   * Using incoming function to check each Character of a String, ensure the String contains specified character
   *
   * @param f a function, to check any character exist in the string
   * @param idx index for traverse Seq or Array, saving the current index for tailrec
   * @return If String contain any Character make incoming function return true, return true; else return false
   */
  @tailrec
  private def anyCharacter(f: Character => Boolean, idx: Int = START_INDEX): Boolean = {
    if (idx == str.length) return false
    if (f.apply(str.charAt(idx))) return true
    anyCharacter(f, idx + 1)
  }

  /**
   * 使用传入的函数遍历检查字符串序列 / 数组中的所有元素，可确保字符串中没有函数指定的字符
   * Using incoming function to check each Character of a String, ensure the String doesn't contains specified character
   *
   * @param f a function, to check any character that don't exist in the string
   * @param idx index for traverse Seq or Array, saving the current index for tailrec
   * @return If String doesn't contain any Character make incoming function return true, return true; else return false
   */
  @tailrec
  private def noneCharacter(f: Character => Boolean, idx: Int = START_INDEX): Boolean = {
    if (idx == str.length) return true
    if (f.apply(str.charAt(idx))) return false
    noneCharacter(f, idx + 1)
  }

}

