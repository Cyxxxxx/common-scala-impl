package cn.yuc.common.bean;

import cn.yuc.common.entity.Bean1;
import cn.yuc.common.entity.Bean2;
import cn.yuc.common.japi.BeanUtils;

public class JavaTest {
    public static void main(String[] args) {
        // Bean1 init
        Bean1 bean1 = new Bean1();
        bean1.setStr("123");
        bean1.setId(123456);
        Bean1 bean1a = new Bean1();
        bean1a.setStr("123");
        bean1a.setId(123456);

        bean1.setBean1(bean1a);

        // usage1
        Bean2 bean2Usage1 = BeanUtils.transform(bean1, Bean2.class);
        System.out.println(bean2Usage1);
        // Bean2{id=123456, idx=0, str='123', b=false, bean1=Bean1{id=123456, idx=0, str='123', b=false, bean1=null}}

        // if two bean have no field in common:
//        Bean3 transform1 = BeanUtils.transform(bean1, Bean3.class);
//        System.out.println(transform1); // exception thrown: Bean1 and Bean3 have no field in common

        // usage2
        Bean2 bean2Usage2 = new Bean2();
        BeanUtils.copyProperties(bean1,bean2Usage2);
        System.out.println(bean1);
        // Bean1{id=123456, idx=0, str='123', b=false, bean1=Bean1{id=123456, idx=0, str='123', b=false, bean1=null}}

        System.out.println(bean2Usage2);
        // Bean2{id=123456, idx=0, str='123', b=false, bean1=Bean1{id=123456, idx=0, str='123', b=false, bean1=null}}

        bean1a.setB(true); // Note: The copy of reference type is shallow copy
        // 注意：对于引用类型的拷贝为浅拷贝，设置bean1a的值影响了bean2中bean1的值
        System.out.println(bean2Usage2);
        /* Bean2{id=123456, idx=0, str='123', b=false, bean1=Bean1{id=123456, idx=0, str='123', b=true, bean1=null}}
        *                                                                                         ^
        */


    }
}
