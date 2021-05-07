package cn.yuc.common

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/**
 * 一个数组工具类，为数组的操作、转换提供相关的函数
 * an array utils, providing related functions for array operations and conversions
 *
 * @author Yuc
 */
object ArrayUtils {
  /**
   * 返回一个不可变的List
   * return a immutable list
   *
   * @param array the array you want it to be a immutable list
   * @return @scala.collection.immutable.List
   */
  def asImmutableList(array: Array[_]): List[_] = {
    array.toList
  }

  /**
   * 返回一个可变的ListBuffer
   * return a ListBuffer (mutable)
   *
   * @param array the array you want it to be a immutable list
   * @return @scala.collection.mutable.ListBuffer
   */
  def asListBuffer(array: Array[_]): ListBuffer[_] = {
    ListBuffer() ++= array
  }

  /**
   * 返回一个Java中可变的List
   * return a mutable List in Java
   *
   * @param array the array you want it to be a mutable list
   * @return @java.util.List
   */
  def asJavaMutableList(array: Array[_]): java.util.List[_] = {
    import scala.collection.JavaConversions._
    asListBuffer(array)
  }


  /**
   * 检查一个数组中是否含有null，若含有null，返回true，否则返回false
   * check if an array contains null
   * @param array the array ready to check
   * @return if the array contains null, return true, else return false
   */
  def anyNull(array: Array[_]): Boolean = !noneNull(array, 0)

  /**
   * 检查一个数组中是否含有null，若不含有null，返回true，否则返回false
   * check if an array contains null
   *
   * @param array the array ready to check
   * @return if the array contains null, return false, else return true
   */
  def noneNull(array: Array[_]): Boolean = noneNull(array, 0)

  @tailrec
  @inline private def noneNull(array: Array[_], idx: Int = 0): Boolean = {
    if (idx == array.length) return true
    if(array(idx)==null) return false
    noneNull(array, idx + 1)
  }

}
