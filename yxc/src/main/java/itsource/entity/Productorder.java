package itsource.entity;

import java.io.Serializable;

/**
 * (Productorder)实体类
 *
 * @author makejava
 * @since 2022-09-25 01:28:55
 */
public class Productorder implements Serializable {
    private static final long serialVersionUID = 673687083682638734L;
    /**
     * 产品、订单中间表
     */
    private Long id;
    /**
     * 关联订单流水号
     */
    private String oid;
    /**
     * 关联产品id
     */
    private Long pid;
    /**
     * 购买产品数量
     */
    private Integer number;

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    /**
     * 产品单价
     */
    private Object price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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


}

