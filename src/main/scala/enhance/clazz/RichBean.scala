package cn.yuc.common
package enhance.clazz

import scala.reflect.{ClassTag, classTag}

/**
 * 为Bean提供便捷的转换函数
 * provide convenient transformation function for beans
 *
 * @param bean
 */
class RichBean(bean: Object) {

  /**
   * 获取目标类实例
   * get an instance of target class
   *
   * @param targetClazz target class
   * @tparam T type
   * @return an instance of target class
   */
  private def newTargetInstance[T](targetClazz: Class[T]): T = {
    val targetObject = try {
      // 若目标类存在无参构造器，尝试获取无参构造器
      val clazzConstructor = targetClazz.getDeclaredConstructor()
      clazzConstructor.setAccessible(true)
      clazzConstructor.newInstance()
    } catch {
      case _: java.lang.NoSuchMethodException => {
        // 当目标类不存在无参构造器，随便获取一个构造器传入零值
        val declaredConstructors = targetClazz.getDeclaredConstructors
        assert(declaredConstructors.nonEmpty, "\ntarget class don't have any constructor!\n目标类不存在任何构造器！")
        val clazzConstructor = declaredConstructors(0)
        val array = clazzConstructor.getParameterTypes
        clazzConstructor.setAccessible(true)
        val array1 = array.map {
          case x if ClassUtils.isNumericType(x) => 0.asInstanceOf[Object]
          case x if x.isAssignableFrom(classOf[Char]) => '0'.asInstanceOf[Object]
          case x if x.isAssignableFrom(classOf[Boolean]) => false.asInstanceOf[Object]
          case _ => null
        }
        japi.ClassUtils.newInstance(clazzConstructor, array1)
      }
      case e: Exception => e.printStackTrace()
    }
    targetObject.asInstanceOf[T]
  }

  /**
   * 在Scala中可直接使用to函数将对象字段复制给目标类对象（前提是两个类型间有相同的字段）
   * In Scala, you can use `bean.to[OtherBean]` to copy that bean's field to `OtherBean` if these two class have common field
   *
   * @tparam T the type you want
   * @return a bean that its type u want
   */
  def to[T: ClassTag]: T = {
    val targetClazz = classTag[T].runtimeClass
    val targetObject = newTargetInstance(targetClazz).asInstanceOf[Object]
    // 为新对象赋值
    BeanUtils.copyProperties(bean, targetObject)
    targetObject.asInstanceOf[T]
  }
}
