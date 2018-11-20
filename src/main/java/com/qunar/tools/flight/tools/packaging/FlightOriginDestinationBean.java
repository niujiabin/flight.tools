package com.qunar.tools.flight.tools.packaging;

import java.util.Objects;

/**
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
    private String departureDate;

    public FlightOriginDestinationBean() {
    }

    public FlightOriginDestinationBean(String origin, String destination, String dateOfTakeOff) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = dateOfTakeOff;
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


    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
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

        return Objects.equals(f.getDepartureDate(), departureDate)
                && Objects.equals(f.getDestination(), destination)
                && Objects.equals(f.getOrigin(), origin);
    }


    @Override
    public int hashCode() {
        int result = origin != null ? origin.hashCode() : 0;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FlightOriginDestinationBean{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                '}';
    }

}
