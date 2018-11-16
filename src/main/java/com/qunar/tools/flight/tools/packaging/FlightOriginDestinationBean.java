package com.qunar.tools.flight.tools.packaging;

import java.util.Objects;

/**
 *
 * @author jiabin.niu
 * @date 2018.11
 * <p>
 * apply to save destination and Origin info
 */
public class FlightOriginDestinationBean {

    /**
     * 始发地
     */
    private String origin;
    /**
     * 目的地
     */
    private String destination;

    /**
     * 起飞日期
     */
    private String dateOfTakeOff;

    public FlightOriginDestinationBean(String origin, String destination, String dateOfTakeOff) {
        this.origin = origin;
        this.destination = destination;
        this.dateOfTakeOff = dateOfTakeOff;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDateOfTakeOff() {
        return dateOfTakeOff;
    }

    public void setDateOfTakeOff(String dateOfTakeOff) {
        this.dateOfTakeOff = dateOfTakeOff;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlightOriginDestinationBean)) {
            return false;
        }

        FlightOriginDestinationBean f = (FlightOriginDestinationBean) obj;

        return Objects.equals(f.getDateOfTakeOff(), dateOfTakeOff)
                && Objects.equals(f.getDestination(), destination)
                && Objects.equals(f.getOrigin(), origin);
    }


    @Override
    public int hashCode() {
        int result = origin != null ? origin.hashCode() : 0;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (dateOfTakeOff != null ? dateOfTakeOff.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FlightOriginDestinationBean{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", dateOfTakeOff='" + dateOfTakeOff + '\'' +
                '}';
    }

}
