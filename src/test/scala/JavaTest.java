package cn.yuc.common;

import cn.yuc.common.entity.Bean1;
import cn.yuc.common.entity.Bean2;
import cn.yuc.common.entity.Bean3;
import cn.yuc.common.japi.BeanUtils;

public class JavaTest {
    public static void main(String[] args) {
        Bean1 bean1 = new Bean1();
        bean1.setStr("123");
        bean1.setId(123456);
        Bean2 transform = BeanUtils.transform(bean1, Bean2.class);
        System.out.println(transform);
        Bean3 transform1 = BeanUtils.transform(bean1, Bean3.class);
        System.out.println(transform1); // exception thrown: Bean1 and Bean3 have no field in common
    }
}
