package cn.yuc.scala.common

import scala.annotation.tailrec

/**
 * StringUtils的Scala实现，兼容Java和Scala代码
 * A StringUtils impl by Scala that can be used on both Java and Scala code.
 *
 * @author YuC
 */
case object StringUtils {

  import StringImplicitClasses._

  /**
   * 检查一个字符串是否为null或不存在任何字符
   * Checks if a String is empty ("") or null
   *
   * StringUtils.isNullOrEmpty(null) => true
   * StringUtils.isNullOrEmpty("") => true
   * StringUtils.isNullOrEmpty("abc") => false
   *
   * @param str the String to check, may be null or empty
   * @return if the String is null or empty
   */
  def isNullOrEmpty(str: String): Boolean = str.isNullOrEmpty

  /**
   * !StringUtils.isNullOrEmpty(str)
   * @param str the String to check, may be null or empty
   * @return a opposite result of StringUtils.isNullOrEmpty(str)
   */
  def isNotNullOrEmpty(str: String): Boolean = !str.isNullOrEmpty

  /**
   * 检查一个字符串是否为空或纯空格
   * Checks if a String is whitespace only(" ","    ",etc..), empty("") or null
   *
   * @param str the String to check, may be blank
   * @return if the String is blank
   */
  def isBlank(str: String): Boolean = str.isBlank

  /**
   * 检查一个字符串是否为数字
   * Checks if a String is numeric
   *
   * StringUtils.isNumeric("123") => true
   * StringUtils.isNumeric("123 ") => false
   * StringUtils.isNumeric("123a") => false
   *
   * @param str the String to check, may be numeric
   * @return if the String is numeric
   */
  def isNumeric(str: String): Boolean = str.isNumeric

  /**
   * 检查一个字符串是否为带空格的数字
   * Checks if a String is numeric with space
   *
   * StringUtils.isNumericSpace("1 23") => true
   * StringUtils.isNumericSpace("123") => true
   * StringUtils.isNumericSpace(" ") => false
   * StringUtils.isNumericSpace("123a") => false
   * StringUtils.isNumericSpace("12-3") => false
   * StringUtils.isNumericSpace("12.3") => false
   *
   * @param str the String to check, may be numeric with space
   * @return if the String is numeric with space
   */
  def isNumericSpace(str: String): Boolean = str.isNumericSpace

  /**
   * 检查一个字符串是否为纯空格
   * Checks if a String is white space
   *
   * StringUtils.isWhiteSpace(null) => false
   * StringUtils.isWhiteSpace("") => false  // Empty string shouldn't be a white space
   * StringUtils.isWhiteSpace("a") => false
   * StringUtils.isWhiteSpace(" ") => true
   *                           ^^ any number of spaces
   * @param str the String to check, may be white space
   * @return
   */
  def isWhiteSpace(str: String): Boolean = str.isWhiteSpace

  /**
   * 检查一个字符串序列、数组是否含有空 / 纯空格字符串
   * Checks if a String Seq has any blank
   *
   * In Java, plz use it by this way:{
   *   StringUtils.isAnyBlank(new String[]{"abc", "avc", ""}) => true
   * }
   * Or in Scala, u can use it simply:{
   *   StringUtils.isAnyBlank("abc", "avc", "") => true
   *   or
   *   Array("abc", "avc", "cce").isAnyBlank => false
   * }
   *
   *
   * @param strings the String Seq or String Array to check, may contain blank
   * @return if any of the String Seq are empty or null or whitespace only
   */
  def isAnyBlank(strings: String*): Boolean = isAnyBlank(strings.toArray)

  def isAnyBlank(strings: Array[String]): Boolean = strings.isAnyBlank

  /**
   * 检查一个字符串序列、数组是否不含有空 / 纯空格字符串
   * Checks if a String Seq has any blank
   *
   * In Java, plz use it by this way:{
   *   StringUtils.isNoneBlank(new String[]{"abc", "avc", ""}) => false
   * }
   * In Scala, u can use it by this way: StringUtils.isNoneBlank(Array("abc", "avc", "")) => false
   * Or u can use it simply: {
   *   StringUtils.isNoneBlank("abc", "avc", "cce") => true
   *   or
   *   Array("abc", "avc", "cce").isNoneBlank => true
   * }
   *
   * @param strings the String Seq or String Array to check, may not contain blank
   * @return if none of the String Seq are empty or null or whitespace only
   */
  def isNoneBlank(strings: String*): Boolean = !isAnyBlank(strings.toArray)

  def isNoneBlank(strings: Array[String]): Boolean = !isAnyBlank(strings)

}

object StringImplicitClasses {
  val START_INDEX = 0
  /**
   * <p>
   * Scala用户专用
   * 在代码中通过import cn.yuc.common.StringImplicitClasses._ 或者 cn.yuc.common.StringImplicitClasses.RichString
   * 即可使用隐式转换对String对象直接调用相关方法
   *
   * For scala users
   * import cn.yuc.common.StringImplicitClasses._ or cn.yuc.common.StringImplicitClasses.RichString
   * you can check a String object like that:
   * </p>
   * str.isNull <==> str == null
   * str.isNullOrEmpty <==> StringUtils.isNullOrEmpty(str)
   * !str.isNullOrEmpty <==> StringUtils.isNotNullOrEmpty(str)
   * str.isBlank <==> StringUtils.isBlank(str)
   * etc..
   *
   * @param str String => RichString
   */
  @inline implicit class RichString(str: String) {

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

  /**
   * <p>
   * Scala用户专用
   * 在代码中通过import cn.yuc.common.StringImplicitClasses._ 或者 cn.yuc.common.StringImplicitClasses.RichStringArray
   * 即可使用隐式转换对String对象直接调用相关方法
   *
   * For scala users
   * import cn.yuc.common.StringImplicitClasses._ or cn.yuc.common.StringImplicitClasses.RichStringArray
   * you can check a String object like that:
   * </p>
   * val strArr = Array("a","b","","d")
   * strArr.isAnyBlank <==> StringUtils.isAnyBlank(strArr)
   * strArr.isNoneBlank <==> StringUtils.isNoneBlank(strArr)
   * etc..
   *
   * @param strings Array[String] => RichStringArray
   */
  @inline implicit class RichStringArray(strings: Array[String]) {

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

}