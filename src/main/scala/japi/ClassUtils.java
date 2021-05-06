package cn.yuc.common.japi;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 用于操作Class对象的Utils，提供一些对Class对象的操作
 * A utils provides some operations for Class object
 * @author YuC
 */
public class ClassUtils {

    /**
     * 为Scala包装蛋疼的Java变长参数方法： 在Scala中，无法直接传递scala数组给Java中的变长参数
     * warp Java variable length parameters function up for scala: In Scala, you can't directly pass scala Array to variable-length parameters to Java
     * @param constructor the constructor ready to new instance
     * @param args the params(Array) ready to pass to newInstance(Object ... initargs)
     * @return an instance born from constructor
     * @throws IllegalAccessException exception may throw by newInstance(Object ... initargs)
     * @throws InvocationTargetException exception may throw by newInstance(Object ... initargs)
     * @throws InstantiationException exception may throw by newInstance(Object ... initargs)
     */
    public static Object newInstance(Constructor constructor, Object[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return constructor.newInstance(args);
    }

}
