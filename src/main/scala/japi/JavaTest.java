package cn.yuc.common.japi;


public class JavaTest {
    public static void main(String[] args) {
        String a = "123";
        String[] strings = {"a","b","c"};
//        System.out.println(StringUtils.isAnyBlank("a", "b", "c", " "));
        System.out.println(ArrayUtils.asMutableList(strings));
        System.out.println(ArrayUtils.asImmutableList(strings));
        ArrayUtils.asMutableList(strings).add("d");
        ArrayUtils.asImmutableList(strings).add("d");
    }

}
