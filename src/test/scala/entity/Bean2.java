package cn.yuc.common.entity;

public class Bean2 {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    private Bean1 b1;

    @Override
    public String toString() {
        return "Bean2{" +
                "id=" + id +
                ", idx=" + idx +
                ", str='" + str + '\'' +
                ", b=" + b +
                ", b1=" + b1 +
                '}';
    }
}
