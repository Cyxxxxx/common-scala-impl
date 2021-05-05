package cn.yuc.scala.common;
public class JavaTest {
    public static void main(String[] args) {
        String a = "";
        System.out.println(StringUtils.isWhiteSpace(a));
        System.out.println(StringUtils.isWhiteSpace("  "));
        System.out.println(StringUtils.isWhiteSpace(null));

    }
}
