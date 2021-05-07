package cn.yuc.common.japi;

import scala.reflect.ClassTag$;

/**
 * 用于操作Bean的Utils，提供一些对Bean对象的操作
 * A utils provides some operations for bean object
 * @author YuC
 */
public class BeanUtils {

    /**
     * 为Java包装的transform方法，提供对象的转换操作
     * BeanUtils.transform(bean,OtherBean.class) <==> org.springframework.beans.BeanUtils.copyProperties(bean,targetBean)
     * @param bean the bean you want to transform
     * @param clazz the class you want to transform
     * @param <T> the type of class
     * @return a bean that its type u want
     */
    public static <T> T transform(Object bean, Class<T> clazz) {
        return cn.yuc.common.BeanUtils.transform(bean,ClassTag$.MODULE$.apply(clazz));
    }

    /**
     * this.copyProperties(source,target) <==> org.springframework.beans.BeanUtils.copyProperties(source,target)
     * @param source source bean you want to copy properties from
     * @param target target bean you want to copy properties to
     */
    public static void copyProperties(Object source,Object target){
        cn.yuc.common.BeanUtils.copyProperties(source,target);
    }

}
