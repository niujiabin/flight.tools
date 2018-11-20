package com.qunar.tools.flight.tools.router;

import java.io.Serializable;

/**
 * 座位状态
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class CabinStatus implements Serializable {

    private static final long serialVersionUID = -3427464222591845360L;

    /**
     * 剩余座位数
     */
    private String remainSeatCount;

    /**
     * AV源
     */
    private String avSource;




    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getRemainSeatCount() {
        return remainSeatCount;
    }

    public void setRemainSeatCount(String remainSeatCount) {
        this.remainSeatCount = remainSeatCount;
    }

    public String getAvSource() {
        return avSource;
    }

    public void setAvSource(String avSource) {
        this.avSource = avSource;
    }

    @Override
    public String toString() {
        return "CabinStatus{" +
                "remainSeatCount='" + remainSeatCount + '\'' +
                ", avSource='" + avSource + '\'' +
                '}';
    }
}
