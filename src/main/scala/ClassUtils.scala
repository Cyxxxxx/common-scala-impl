package cn.yuc.common

import java.lang.reflect.Field

/**
 * 用于操作Class对象的Utils，提供一些对Class对象的操作
 * A utils provides some operations for Class object
 *
 * @author YuC
 */
object ClassUtils {

  /**
   * 检查Class类型是否为数字类型
   * check if the Class is numeric type
   *
   * @param clazz the Class object ready to check
   * @return if the Class is numeric type, return true, else return false
   */
  def isNumericType(clazz: Class[_]): Boolean = {
    clazz.isAssignableFrom(classOf[Byte]) || clazz.isAssignableFrom(classOf[Short]) ||
      clazz.isAssignableFrom(classOf[Int]) || clazz.isAssignableFrom(classOf[Long]) ||
      clazz.isAssignableFrom(classOf[Float]) || clazz.isAssignableFrom(classOf[Double])
  }

  /**
   * 在两个类型中获取相同的字段
   *
   * @param clazz1
   * @param clazz2
   * @return
   */
  def getCommonFields(clazz1: Class[_], clazz2: Class[_]): (Array[Field], Array[Field], Set[String]) = {
    val commonFieldsName = getCommonFieldsNameSet(clazz1.getDeclaredFields, clazz2.getDeclaredFields)
    // 同名同类型参数为空时，使用断言中断步骤
    assert(commonFieldsName.nonEmpty, s"\n\t${clazz1.getName} and ${clazz2.getName} have no fields in common!\n" +
      s"\t类${clazz1.getName}和${clazz2.getName}之间无任何同类型同名参数！")
    (clazz1.getDeclaredFields, clazz2.getDeclaredFields, commonFieldsName)
  }


  /**
   * 在两个Field数组中获取同名同类型的字段
   * get common field from two Array[Field]
   *
   * @param fields1 the first Array[Field]
   * @param fields2 the second Array[Field]
   * @return name of common fields
   */
  def getCommonFieldsNameSet(fields1: Array[Field], fields2: Array[Field]): Set[String] = {
    // null check
    assert(fields1 != null && fields2 != null, "param contains null")
    assert(ArrayUtils.noneNull(fields1) && ArrayUtils.noneNull(fields2), "array param contains null")
    (fields1.map(f => (f.getName, f.getType)).toSet & fields2.map(f => (f.getName, f.getType)).toSet).map(_._1)
  }

}
