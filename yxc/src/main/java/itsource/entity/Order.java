package itsource.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2022-09-25 01:28:54
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -93822197924583372L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 1：外卖    0：自取
     */
    private Integer otype;
    /**
     * 订单流水号
     */
    private String onumber;
    /**
     * 关联用户表id
     */
    private Long uid;
    /**
     * 订单价格
     */
    private Object oprice;
    /**
     * 支付状态 0:未支付   1：已经支付
     */
    private Integer paystate;
    /**
     * 支付时间
     */
    private String otime;
    /**
     * 订单状态：0：预定中（未收获） 1：已收货 2：退订 3：禁用
     */
    private Integer ostate;

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOtype() {
        return otype;
    }

    public void setOtype(Integer otype) {
        this.otype = otype;
    }

    public String getOnumber() {
        return onumber;
    }

    public void setOnumber(String onumber) {
        this.onumber = onumber;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Object getOprice() {
        return oprice;
    }

    public void setOprice(Object oprice) {
        this.oprice = oprice;
    }

    public Integer getPaystate() {
        return paystate;
    }

    public void setPaystate(Integer paystate) {
        this.paystate = paystate;
    }

    public String getOtime() {
        return otime;
    }

    public void setOtime(String otime) {
        this.otime = otime;
    }

    public Integer getOstate() {
        return ostate;
    }

    public void setOstate(Integer ostate) {
        this.ostate = ostate;
    }

}

