package cn.yuc.common

import enhance.PredefEnhancer.beanWrapper

import scala.reflect.ClassTag

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
   *
   * @param source source bean you want to copy properties from
   * @param target target bean you want to copy properties to
   */
  def copyProperties(source: Object, target: Object): Unit = {
    // null check
    Asserts.notNull(source, "source must not be null!")
    Asserts.notNull(target, "target must not be null!")
    val (_, targetClazzFields, commonFieldsName) = ClassUtils.getCommonFields(source.getClass, target.getClass)
    for (field <- targetClazzFields if commonFieldsName.contains(field.getName)) {
      field.setAccessible(true)
      val sourceField = source.getClass.getDeclaredField(field.getName)
      sourceField.setAccessible(true)
      field.set(target, sourceField.get(source))
    }
  }


}
