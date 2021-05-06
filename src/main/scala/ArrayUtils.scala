package cn.yuc.common

import scala.collection.mutable.ListBuffer

/**
 * 一个数组工具类，为数组的操作、转换提供相关的函数
 * an array utils, providing related functions for array operations and conversions
 * @author Yuc
 */
object ArrayUtils {
  /**
   * 返回一个不可变的List
   * return a immutable list
   * @param array the array you want it to be a immutable list
   * @return @scala.collection.immutable.List
   */
  def asImmutableList(array: Array[_]): List[_] = {
    array.toList
  }

  /**
   * 返回一个可变的ListBuffer
   * return a ListBuffer (mutable)
   * @param array the array you want it to be a immutable list
   * @return @scala.collection.mutable.ListBuffer
   */
  def asListBuffer(array: Array[_]): ListBuffer[_] = {
    ListBuffer() ++= array
  }

  /**
   * 返回一个Java中可变的List
   * return a mutable List in Java
   * @param array the array you want it to be a mutable list
   * @return @java.util.List
   */
  def asJavaMutableList(array: Array[_]): java.util.List[_] = {
    import scala.collection.JavaConversions._
    asListBuffer(array)
  }
}
