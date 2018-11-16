package com.qunar.tools.flight.tools.packaging;

import com.qunar.tools.flight.tools.common.FlightExtensionInfo;
import com.qunar.tools.flight.tools.common.TripType;
import com.qunar.tools.flight.tools.common.User;
import com.qunar.tools.flight.tools.product.ProductStrategyBean;
import com.qunar.tools.flight.tools.product.ProductTagBean;
import com.qunar.tools.flight.tools.router.AgentBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jiabin.niu
 * @date 2018.11
 * <p>
 * the param apply to Package Handler
 */
public class PackageParam implements Serializable {

    private static final long serialVersionUID = -1;

    /**
     * 起飞 到达目的地 & 起飞日期
     */
    private List<FlightOriginDestinationBean> flightOriginDestinationBean;

    /**
     * 包装id
     */
    private long packageId;
    /**
     * 请求源
     */
    private String requestSource;

    /**
     * 包装的tag
     */
    private Set<ProductTagBean> productTagBeanSet;

    /**
     * 代理商信息
     */
    private Set<AgentBean> agentBeans;

    /**
     * 成人数量
     */
    private int adultNumber;

    /**
     * 儿童数量
     */
    private int childrenNumber;

    /**
     * 航班组合列表
     */
    private Set<FlightCombination> flightCombinations;

    /**
     * 附加信息
     */
    private Map<String, Object> ext;

    /**
     * 各个系统间查询标识
     */
    private String queryId;

    /**
     * 查询用户信息
     */
    private User user;

    /**
     * 查询类型
     */
    private String queryType;

    /**
     * 符合tag的策略类型
     */
    private Set<ProductStrategyBean> productStrategyBeans;

    /**
     * 是否是增量包装
     */
    private boolean isIncrement;

    /**
     * 单程 or 往返 or 缺口
     */
    private int tripType;

    public int tripType() {

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


    public boolean isIncrement() {
        return isIncrement;
    }

    public void setIncrement(boolean increment) {
        isIncrement = increment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public Set<ProductStrategyBean> getProductStrategyBeans() {
        return productStrategyBeans;
    }

    public void setProductStrategyBeans(Set<ProductStrategyBean> productStrategyBeans) {
        this.productStrategyBeans = productStrategyBeans;
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<FlightOriginDestinationBean> getFlightOriginDestinationBean() {
        return flightOriginDestinationBean;
    }

    public void setFlightOriginDestinationBean(List<FlightOriginDestinationBean> flightOriginDestinationBean) {
        this.flightOriginDestinationBean = flightOriginDestinationBean;
    }

    public long getPackageId() {
        return packageId;
    }

    public void setPackageId(long packageId) {
        this.packageId = packageId;
    }

    public String getRequestSource() {
        return requestSource;
    }

    public void setRequestSource(String requestSource) {
        this.requestSource = requestSource;
    }

    public Set<ProductTagBean> getProductTagBeanSet() {
        return productTagBeanSet;
    }

    public void setProductTagBeanSet(Set<ProductTagBean> productTagBeanSet) {
        this.productTagBeanSet = productTagBeanSet;
    }

    public Set<AgentBean> getAgentBeans() {
        return agentBeans;
    }

    public void setAgentBeans(Set<AgentBean> agentBeans) {
        this.agentBeans = agentBeans;
    }

    public int getAdultNumber() {
        return adultNumber;
    }

    public void setAdultNumber(int adultNumber) {
        this.adultNumber = adultNumber;
    }

    public int getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(int childrenNumber) {
        this.childrenNumber = childrenNumber;
    }

    public Set<FlightCombination> getFlightCombinations() {
        return flightCombinations;
    }

    public void setFlightCombinations(Set<FlightCombination> flightCombinations) {
        this.flightCombinations = flightCombinations;
    }

    public Map<String, Object> getExt() {
        return ext;
    }

    public void setExt(Map<String, Object> ext) {
        this.ext = ext;
    }
}
