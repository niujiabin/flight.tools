package com.qunar.tools.flight.tools.common;

/**
 * @author jiabin.niu
 * @date 2018.11
 */
public class FlightPriceKey {

    /**
     * 座位等级
     * 头等舱/经济舱  头等舱/经济舱
     */
    private String seatLevel;


    /**
     * 舱位  F/Y  -   F/Y
     */
    private String cabin;


    /**
     * 价格类型
     */
    private FlightPriceType priceType;

    /**
     * 出行工具  航班组合 CA1234/CA1235 - MX111/MX112
     */
    private String code;

    /**
     * 资质报价
     */
    private String qualification;

    /**
     * 包装tag
     */
    private String packagingTag;
    /**
     * 在merge操作中设置的一些信息
     */
    private MergeExtData mergeExtData;

    public MergeExtData getMergeExtData() {
        return mergeExtData;
    }

    public void setMergeExtData(MergeExtData mergeExtData) {
        this.mergeExtData = mergeExtData;
    }

    public String getPackagingTag() {
        return packagingTag;
    }

    public void setPackagingTag(String packagingTag) {
        this.packagingTag = packagingTag;
    }

    public String getSeatLevel() {
        return seatLevel;
    }

    public void setSeatLevel(String seatLevel) {
        this.seatLevel = seatLevel;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public FlightPriceType getPriceType() {
        return priceType;
    }

    public void setPriceType(FlightPriceType priceType) {
        this.priceType = priceType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
