package cn.yuc.common

/**
 * 用于操作Class对象的Utils，提供一些对Class对象的操作
 * A utils provides some operations for Class object
 * @author YuC
 */
object ClassUtils {

  /**
   * 检查Class类型是否为数字类型
   * check if the Class is numeric type
   * @param clazz the Class object ready to check
   * @return if the Class is numeric type, return true, else return false
   */
  def isNumericType(clazz: Class[_]): Boolean = {
    clazz.isAssignableFrom(classOf[Byte]) || clazz.isAssignableFrom(classOf[Short]) ||
      clazz.isAssignableFrom(classOf[Int]) || clazz.isAssignableFrom(classOf[Long]) ||
      clazz.isAssignableFrom(classOf[Float]) || clazz.isAssignableFrom(classOf[Double])
  }
}
