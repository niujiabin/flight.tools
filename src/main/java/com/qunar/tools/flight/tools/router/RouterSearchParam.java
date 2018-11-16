package com.qunar.tools.flight.tools.router;

import com.qunar.tools.flight.tools.packaging.FlightOriginDestinationBean;

import java.util.List;

/**
 * router搜索参数
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class RouterSearchParam {


    /**
     *
     */
    private List<FlightOriginDestinationBean> flightOriginDestinationBeanList;

    public List<FlightOriginDestinationBean> getFlightOriginDestinationBeanList() {
        return flightOriginDestinationBeanList;
    }

    public void setFlightOriginDestinationBeanList(List<FlightOriginDestinationBean> flightOriginDestinationBeanList) {
        this.flightOriginDestinationBeanList = flightOriginDestinationBeanList;
    }
}
