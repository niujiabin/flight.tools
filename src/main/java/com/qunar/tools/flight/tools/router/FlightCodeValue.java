package com.qunar.tools.flight.tools.router;

import java.io.Serializable;
import java.util.Map;

/**
 * @author jiabin.niu
 * @date 2018.11
 */
public class FlightCodeValue implements Serializable {
    private static final long serialVersionUID = 7478817846795468553L;

    /**
     * 出发时间
     */
    private String departureTime;

    /**
     * 到达时间
     */
    private String arrivalTime;

    /**
     * 出行工具型号
     */
    private String equipType;

    /**
     * 出行工具代码  如航班号
     */
    private String code;

    /**
     * 实际承运代码
     */
    private String actualCode;

    /**
     * 经停
     */
    private int stops;

    /**
     * 餐食
     */
    private boolean meal;

    /**
     * 到达机场三字码
     */
    private String arrivalCode;


    /**
     * 出发机场三字码
     */
    private String departureCode;

    /**
     * 到达城市
     */
    private String arrivalCity;

    /**
     * 到达日期
     */
    private String arrivalDate;

    /**
     * 航司
     */
    private String airlines;

    /**
     * 是否是共享航班
     */
    private boolean isFlightShare;


    /**
     * 出发城市
     */
    private String departureCity;

    /**
     * 出发日期
     */
    private String departureDate;

    /**
     * 飞行时长
     */
    private long flyTime;


    /**
     * 扩展字段
     */
    private Map<String, String> dataExt;

    /**
     * 座位状态
     */
    private Map<String, CabinStatus> cabinMap;


    /**
     * 是否联程
     */
    private boolean isChange;

    /**
     * 是否座位数比较少
     */
    private boolean isFewerSeat;

    /**
     * 出发航站楼信息
     */
    private String departureTower;

    /**
     * 到达航站楼信息
     */
    private String arrivalTower;

    private int group;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getActualCode() {
        return actualCode;
    }

    public void setActualCode(String actualCode) {
        this.actualCode = actualCode;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public boolean isMeal() {
        return meal;
    }

    public void setMeal(boolean meal) {
        this.meal = meal;
    }

    public String getArrivalCode() {
        return arrivalCode;
    }

    public void setArrivalCode(String arrivalCode) {
        this.arrivalCode = arrivalCode;
    }

    public String getDepartureCode() {
        return departureCode;
    }

    public void setDepartureCode(String departureCode) {
        this.departureCode = departureCode;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }

    public boolean isFlightShare() {
        return isFlightShare;
    }

    public void setFlightShare(boolean flightShare) {
        isFlightShare = flightShare;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public long getFlyTime() {
        return flyTime;
    }

    public void setFlyTime(long flyTime) {
        this.flyTime = flyTime;
    }

    public Map<String, String> getDataExt() {
        return dataExt;
    }

    public void setDataExt(Map<String, String> dataExt) {
        this.dataExt = dataExt;
    }

    public Map<String, CabinStatus> getCabinMap() {
        return cabinMap;
    }

    public void setCabinMap(Map<String, CabinStatus> cabinMap) {
        this.cabinMap = cabinMap;
    }

    public boolean isChange() {
        return isChange;
    }

    public void setChange(boolean change) {
        isChange = change;
    }

    public boolean isFewerSeat() {
        return isFewerSeat;
    }

    public void setFewerSeat(boolean fewerSeat) {
        isFewerSeat = fewerSeat;
    }

    public String getDepartureTower() {
        return departureTower;
    }

    public void setDepartureTower(String departureTower) {
        this.departureTower = departureTower;
    }

    public String getArrivalTower() {
        return arrivalTower;
    }

    public void setArrivalTower(String arrivalTower) {
        this.arrivalTower = arrivalTower;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "FlightCodeValue{" +
                "departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", equipType='" + equipType + '\'' +
                ", code='" + code + '\'' +
                ", actualCode='" + actualCode + '\'' +
                ", stops=" + stops +
                ", meal=" + meal +
                ", arrivalCode='" + arrivalCode + '\'' +
                ", departureCode='" + departureCode + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", airlines='" + airlines + '\'' +
                ", isFlightShare=" + isFlightShare +
                ", departureCity='" + departureCity + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", flyTime=" + flyTime +
                ", dataExt=" + dataExt +
                ", cabinMap=" + cabinMap +
                ", isChange=" + isChange +
                ", isFewerSeat=" + isFewerSeat +
                ", departureTower='" + departureTower + '\'' +
                ", arrivalTower='" + arrivalTower + '\'' +
                ", group=" + group +
                '}';
    }
}
