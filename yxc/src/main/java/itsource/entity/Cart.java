package itsource.entity;

import java.io.Serializable;

/**
 * (Cart)实体类
 *
 * @author makejava
 * @since 2022-09-25 01:28:52
 */
public class Cart implements Serializable {
    private static final long serialVersionUID = -53596835719394563L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 关联用户id
     */
    private Long uid;
    /**
     * 关联产品id
     */
    private Long pid;
    /**
     * 产品数量
     */
    private Integer number;
    
    private Double tprice;

    /**
     * 商品
     * @return
     */
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getTprice() {
        return tprice;
    }

    public void setTprice(Double tprice) {
        this.tprice = tprice;
    }

}

