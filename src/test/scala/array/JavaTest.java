package cn.yuc.common.array;

import cn.yuc.common.japi.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class JavaTest {
    public static void main(String[] args) {
        Integer[] arr = {123,456,789};
        // immutable list
        List<Integer> immutableList = ArrayUtils.asImmutableList(arr);
        System.out.println(immutableList.getClass()); // class java.util.Arrays$ArrayList
        System.out.println(immutableList); // [123, 456, 789]

        // mutable list
        List<Integer> mutableList = ArrayUtils.asMutableList(arr);
        System.out.println(mutableList.getClass()); // class scala.collection.convert.Wrappers$MutableBufferWrapper
        System.out.println(mutableList);  // [123, 456, 789]
        List<Integer> arrayList = new ArrayList<>(mutableList);
        System.out.println(arrayList.getClass()); // class java.util.ArrayList
        System.out.println(arrayList); // [123, 456, 789]
    }
}
