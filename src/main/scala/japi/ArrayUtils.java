package cn.yuc.common.japi;

import java.util.Arrays;
import java.util.List;

/**
 * 一个数组工具类，为数组的操作、转换提供相关的函数
 * an array utils, providing related functions for array operations and conversions
 *
 * @author YuC
 */
public class ArrayUtils {

    /**
     * 返回一个Java中不可变的List
     * return a immutable List in Java
     *
     * @param array the array you want it to be a immutable list
     * @return @java.util.List
     */
    public static <T> List<T> asImmutableList(T[] array) {
        return Arrays.asList(array);
    }

    /**
     * 返回一个Java中可变的List
     * return a mutable List in Java
     *
     * @param array the array you want it to be a mutable list
     * @return @java.util.List
     */
    public static <T> List<T> asMutableList(T[] array) {
        return (List<T>) cn.yuc.common.ArrayUtils.asJavaMutableList(array);
    }

    /**
     * 检查一个数组中是否含有null，若含有null，返回true，否则返回false
     * check if an array contains null
     *
     * @param array the array ready to check
     * @return if the array contains null, return true, else return false
     */
    public static boolean anyNull(Object[] array) {
        return cn.yuc.common.ArrayUtils.anyNull(array);
    }


    /**
     * 检查一个数组中是否含有null，若不含有null，返回true，否则返回false
     * check if an array contains null
     *
     * @param array the array ready to check
     * @return if the array contains null, return false, else return true
     */
    public static boolean noneNull(Object[] array) {
        return cn.yuc.common.ArrayUtils.noneNull(array);
    }

}
