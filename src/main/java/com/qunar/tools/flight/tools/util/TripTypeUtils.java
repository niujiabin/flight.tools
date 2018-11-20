package com.qunar.tools.flight.tools.util;

import com.google.common.base.Joiner;
import com.qunar.tools.flight.tools.common.FlightOriginDesWithRetBean;
import com.qunar.tools.flight.tools.common.TripType;
import com.qunar.tools.flight.tools.packaging.FlightOriginDestinationBean;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 用于判断形成类型相关信息
 *
 * @author jiabin.niu
 * @date 2018.11
 */
public class TripTypeUtils {

    /**
     * 波浪线连接
     */
    private static final Joiner JOINER_WAVE = Joiner.on("~").skipNulls();

    /**
     * 获取形成类型
     *
     * @param flightOriginDestinationBean 形成组合参数
     * @return 形成类型
     */
    public static TripType getTripType(List<FlightOriginDestinationBean> flightOriginDestinationBean) {
        if (flightOriginDestinationBean.size() == 1) {
            return TripType.ONE_WAY;
        } else if (flightOriginDestinationBean.size() == 2) {
            FlightOriginDestinationBean f1 = flightOriginDestinationBean.get(0);
            FlightOriginDestinationBean f2 = flightOriginDestinationBean.get(1);
            if (f1.getOrigin().equals(f2.getDestination()) && f1.getDestination().equals(f2.getOrigin())) {
                return TripType.ROUND_WAY;
            }
        }
        return TripType.OPEN_JAW;
    }

    /**
     * 行程组合
     *
     * @param flightOriginDestinationBean 行程组合
     * @return 行程组合明细
     */
    public static String getOrigin(final List<FlightOriginDestinationBean> flightOriginDestinationBean) {
        String origin = "";
        if (!CollectionUtils.isEmpty(flightOriginDestinationBean)) {
            TripType t = getTripType(flightOriginDestinationBean);
            if (t == TripType.OPEN_JAW) {
                origin = JOINER_WAVE.join(flightOriginDestinationBean.stream().map(f -> f.getOrigin()).collect(Collectors.toList()));
            } else {
                origin = flightOriginDestinationBean.get(0).getOrigin();
            }
        }
        return origin;
    }


    /**
     * 获取目的地信息
     *
     * @param flightOriginDestinationBean
     * @return 目的地
     */
    public static String getDestination(final List<FlightOriginDestinationBean> flightOriginDestinationBean) {
        String destination = "";
        if (!CollectionUtils.isEmpty(flightOriginDestinationBean)) {
            TripType t = getTripType(flightOriginDestinationBean);
            if (t == TripType.OPEN_JAW) {
                destination = JOINER_WAVE.join(flightOriginDestinationBean.stream().map(f -> f.getDestination()).collect(Collectors.toList()));
            } else {
                destination = flightOriginDestinationBean.get(0).getDestination();
            }
        }
        return destination;
    }

    /**
     * 获取出发日期
     *
     * @param flightOriginDestinationBean
     * @return 出发日期
     */
    public static String getDepartureDate(final List<FlightOriginDestinationBean> flightOriginDestinationBean) {
        String date = "";
        if (!CollectionUtils.isEmpty(flightOriginDestinationBean)) {
            TripType t = getTripType(flightOriginDestinationBean);
            if (t == TripType.OPEN_JAW) {
                date = JOINER_WAVE.join(flightOriginDestinationBean.stream().map(f -> f.getDepartureDate()).collect(Collectors.toList()));
            } else {
                date = flightOriginDestinationBean.get(0).getDepartureDate();
            }
        }
        return date;
    }

    /**
     * 获取返程日期
     *
     * @param flightOriginDestinationBean
     * @return 出发日期
     */
    public static String getReturnDate(final List<FlightOriginDestinationBean> flightOriginDestinationBean) {
        String date = "";
        //flightOriginDestinationBean大小大于1
        if (FlightCollectionUtils.sizeLargerThan(flightOriginDestinationBean, 1)) {
            date = flightOriginDestinationBean.get(1).getDepartureDate();
        }
        return date;
    }

    /**
     * 获取形成信息
     *
     * @param flist
     * @return
     */
    public static FlightOriginDesWithRetBean getFlightOriginDesWithRes(List<FlightOriginDestinationBean> flist) {
        final FlightOriginDesWithRetBean fb = new FlightOriginDesWithRetBean();

        if (!CollectionUtils.isEmpty(flist)) {
            TripType t = getTripType(flist);
            if (t == TripType.OPEN_JAW) {
                fb.setOrigin(JOINER_WAVE.join(flist.stream().map(f -> f.getOrigin()).collect(Collectors.toList())));
                fb.setDepartureDate(JOINER_WAVE.join(flist.stream().map(f -> f.getDepartureDate()).collect(Collectors.toList())));
                fb.setDestination(JOINER_WAVE.join(flist.stream().map(f -> f.getDestination()).collect(Collectors.toList())));
            }
        } else {
            FlightOriginDestinationBean flightOriginDestinationBean = flist.get(0);
            fb.setDestination(flightOriginDestinationBean.getDestination());
            fb.setOrigin(flightOriginDestinationBean.getOrigin());
            fb.setDepartureDate(flightOriginDestinationBean.getDepartureDate());
            if (FlightCollectionUtils.sizeLargerThan(flist, 1)) {
                fb.setReturnDate(flist.get(1).getDepartureDate());
            }
        }
        return fb;
    }
}
