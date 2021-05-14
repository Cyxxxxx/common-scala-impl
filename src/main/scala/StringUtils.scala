package cn.yuc.common

import enhance.PredefEnhancer._

/**
 * StringUtils的Scala实现，兼容Java和Scala代码
 * A StringUtils impl by Scala that can be used on both Java and Scala code.
 *
 * @author YuC
 */
case object StringUtils {


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
   *
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
   * ^^ any number of spaces
   *
   * @param str the String to check, may be white space
   * @return
   */
  def isWhiteSpace(str: String): Boolean = str.isWhiteSpace

  /**
   * 检查一个字符串序列、数组是否含有空 / 纯空格字符串
   * Checks if a String Seq has any blank
   *
   * In Java, plz use it by this way:{
   * StringUtils.isAnyBlank(new String[]{"abc", "avc", ""}) => true
   * }
   * Or in Scala, u can use it simply:{
   * StringUtils.isAnyBlank("abc", "avc", "") => true
   * or
   * Array("abc", "avc", "cce").isAnyBlank => false
   * }
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
   * StringUtils.isNoneBlank(new String[]{"abc", "avc", ""}) => false
   * }
   * In Scala, u can use it by this way: StringUtils.isNoneBlank(Array("abc", "avc", "")) => false
   * Or u can use it simply: {
   * StringUtils.isNoneBlank("abc", "avc", "cce") => true
   * or
   * Array("abc", "avc", "cce").isNoneBlank => true
   * }
   *
   * @param strings the String Seq or String Array to check, may not contain blank
   * @return if none of the String Seq are empty or null or whitespace only
   */
  def isNoneBlank(strings: String*): Boolean = !isAnyBlank(strings.toArray)

  def isNoneBlank(strings: Array[String]): Boolean = !isAnyBlank(strings)

}

