package cn.yuc.common.entity;

public class Bean1 {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bean1{" +
                "id=" + id +
                ", idx=" + idx +
                ", str='" + str + '\'' +
                ", b=" + b +
                ", bean1=" + bean1 +
                '}';
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    private int idx;

    private String str;

    private boolean b;

    public Bean1 getBean1() {
        return bean1;
    }

    public void setBean1(Bean1 bean1) {
        this.bean1 = bean1;
    }

    private Bean1 bean1;
}
