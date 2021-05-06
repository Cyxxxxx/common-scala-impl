package cn.yuc.common.japi;
/**
 * StringUtils的Java兼容接口
 * @author YuC
 */
public class StringUtils {

    public static boolean isNullOrEmpty(String string){
        return cn.yuc.common.StringUtils.isNullOrEmpty(string);
    }

    public static boolean isNotNullOrEmpty(String string){
        return !isNullOrEmpty(string);
    }

    public static boolean isBlank(String string){
        return cn.yuc.common.StringUtils.isBlank(string);
    }

    public static boolean isWhiteSpace(String string){
        return cn.yuc.common.StringUtils.isWhiteSpace(string);
    }

    public static boolean isNumeric(String string){
        return cn.yuc.common.StringUtils.isNumeric(string);
    }

    public static boolean isNumericSpace(String string){
        return cn.yuc.common.StringUtils.isNumericSpace(string);
    }

    /**
     * 使用Java变长参数包装Scala变长参数方法
     * using [String...] to wrap [String*] or [Array[String]] up
     * @param strings String Seq
     * @return if any of the String Seq are empty or null or whitespace only
     */
    public static boolean isAnyBlank(String... strings){
        return cn.yuc.common.StringUtils.isAnyBlank(strings);
    }

    /**
     * 使用Java变长参数包装Scala变长参数方法
     * using [String...] to wrap [String*] or [Array[String]] up
     * @param strings String Seq
     * @return if none of the String Seq are empty or null or whitespace only
     */
    public static boolean isNoneBlank(String... strings){
        return cn.yuc.common.StringUtils.isNoneBlank(strings);
    }

}
