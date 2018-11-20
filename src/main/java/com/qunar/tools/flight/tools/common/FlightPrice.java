package com.qunar.tools.flight.tools.common;

import com.qunar.tools.flight.tools.router.FlightBasicRouteSegmentKey;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author jiabin.niu
 * @date 2018.11
 */
public class FlightPrice implements Serializable {

    private static final long serialVersionUID = -9205713349631744365L;

    /**
     * 报价类型
     */
    private String priceType;
    /**
     * 票面价格
     */
    private BigDecimal viewPrice;

    /**
     * 成人价格
     */
    private BigDecimal adultPrice;

    /**
     * 成人税费
     */
    private BigDecimal taxAdult;

    /**
     * 政策信息 政策类型-政策id
     */
    private String policyInfo;
    /**
     * 基本航段信息   原来的json  和  legInfoKey有点重复
     * codeInfos: [
     * [
     * {
     * code: "CZ6586",
     * depDate: "2018-11-20",
     * depAp: "PEK",
     * timeRange: null,
     * probability: 1,
     * arrAp: "WUH"
     * },
     * {
     * code: "CZ8343",
     * depDate: "2018-11-21",
     * depAp: "WUH",
     * timeRange: null,
     * probability: 1,
     * arrAp: "BKK"
     * }
     * ],
     * [
     * {
     * code: "CZ3058",
     * depDate: "2018-11-27",
     * depAp: "BKK",
     * timeRange: null,
     * probability: 1,
     * arrAp: "WUH"
     * },
     * {
     * code: "CZ3117",
     * depDate: "2018-11-28",
     * depAp: "WUH",
     * timeRange: null,
     * probability: 1,
     * arrAp: "PEK"
     * }
     * ]
     * ],
     */
    private List<List<FlightBasicRouteSegmentKey>> basicSegmentKeys;

    /**
     * 扩展信息
     */
    private Map<String, String> dataExt;

    /**
     * 价格的唯一标识
     */
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public Map<String, String> getDataExt() {
        return dataExt;
    }

    public void setDataExt(Map<String, String> dataExt) {
        this.dataExt = dataExt;
    }

    public List<List<FlightBasicRouteSegmentKey>> getBasicSegmentKeys() {
        return basicSegmentKeys;
    }

    public void setBasicSegmentKeys(List<List<FlightBasicRouteSegmentKey>> basicSegmentKeys) {
        this.basicSegmentKeys = basicSegmentKeys;
    }

    public String getPolicyInfo() {
        return policyInfo;
    }

    public void setPolicyInfo(String policyInfo) {
        this.policyInfo = policyInfo;
    }

    public void setTaxAdult(BigDecimal taxAdult) {
        this.taxAdult = taxAdult;
    }

    public BigDecimal getTaxAdult() {
        return taxAdult;
    }

    public BigDecimal getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(BigDecimal adultPrice) {
        this.adultPrice = adultPrice;
    }

    public BigDecimal getViewPrice() {
        return viewPrice;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setViewPrice(BigDecimal viewPrice) {
        this.viewPrice = viewPrice;
    }


}
