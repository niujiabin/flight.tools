package com.qunar.tools.flight.tools.common;

import com.qunar.tools.flight.tools.packaging.FlightOriginDestinationBean;

/**
 *
 * 附带返程日期
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class FlightOriginDesWithRetBean extends FlightOriginDestinationBean {

    /**
     *  返程日期
     */
    private String returnDate;

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public FlightOriginDesWithRetBean() {
        super();
    }

    public FlightOriginDesWithRetBean(String origin, String destination, String dateOfTakeOff) {
        super(origin, destination, dateOfTakeOff);
    }
}
