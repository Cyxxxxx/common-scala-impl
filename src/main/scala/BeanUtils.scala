package cn.yuc.common

import scala.reflect.{ClassTag, classTag}

/**
 * 用于操作Bean的Utils，提供一些对Bean对象的操作
 * A utils provides some operations for bean object
 *
 * @author YuC
 */
object BeanUtils {

  /**
   * 若两个类型的Bean含有相同的字段，可以将一个Bean转化为另一种类型的Bean并返回
   * transform the class of a bean to another class, if these classes have common field
   * In Java: BeanUtils.transform(bean,OtherBean.class) <==> org.springframework.beans.BeanUtils.copyProperties(bean,targetBean)
   * In Scala:
   * bean.to[OtherBean] <==>
   * BeanUtils.transform[OtherBean](bean) <==>
   * org.springframework.beans.BeanUtils.copyProperties(bean,targetBean)
   *
   * @param bean the bean you want to transform
   * @tparam T the type of class
   * @return a bean that its type u want
   */
  def transform[T: ClassTag](bean: Object): T = {
    bean.to[T]
  }

  /**
   * this.copyProperties(source,target) <==> org.springframework.beans.BeanUtils.copyProperties(source,target)
   * @param source source bean you want to copy properties from
   * @param target target bean you want to copy properties to
   */
  def copyProperties(source: Object, target: Object): Unit = {
    val (_, targetClazzFields, commonFieldsName) = ClassUtils.getCommonFields(source.getClass, target.getClass)
    for (field <- targetClazzFields if commonFieldsName.contains(field.getName)) {
      field.setAccessible(true)
      val sourceField = source.getClass.getDeclaredField(field.getName)
      sourceField.setAccessible(true)
      field.set(target, sourceField.get(source))
    }
  }


  /**
   * 为Bean提供隐式转换，并为其提供便捷的转换函数
   * provide implicit and convenient transformation function for beans
   *
   * @param bean
   */
  @inline implicit class RichBean(bean: Object) {

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
      val beanClazz = bean.getClass
      val targetObject = newTargetInstance(targetClazz).asInstanceOf[Object]
      // 为新对象赋值
      BeanUtils.copyProperties(bean, targetObject)
      targetObject.asInstanceOf[T]
    }
  }

}
