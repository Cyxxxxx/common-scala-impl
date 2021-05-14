package cn.yuc.common.string;

import cn.yuc.common.japi.StringUtils;

public class JavaTest {
    public static void main(String[] args) {
        // f => false, t => true
        System.out.println(StringUtils.isWhiteSpace("")); // f
        System.out.println(StringUtils.isNumeric("123")); // t
        System.out.println(StringUtils.isNumeric("123a")); // f
        System.out.println(StringUtils.isNumeric("123 ")); // f
        System.out.println(StringUtils.isNumericSpace("123 ")); // t
        System.out.println(StringUtils.isAnyBlank("ab")); // f
        System.out.println(StringUtils.isAnyBlank("")); // t
        System.out.println(StringUtils.isNoneBlank("ab", " ")); // f
        System.out.println(StringUtils.isNoneBlank(" ")); // f
    }
}
