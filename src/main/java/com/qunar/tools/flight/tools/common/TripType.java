package com.qunar.tools.flight.tools.common;

/**
 * 形成类型
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public final class TripType {

    private int type;

    public static final TripType ONE_WAY = new TripType(1);

    public static final TripType ROUND_WAY = new TripType(2);

    public static final TripType OPEN_JAW = new TripType(3);


    public TripType(int tripType) {
        this.type = tripType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TripType tripType = (TripType) o;

        return type == tripType.type;
    }

    @Override
    public int hashCode() {
        return type;
    }
}
