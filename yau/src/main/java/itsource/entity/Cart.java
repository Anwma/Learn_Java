package itsource.entity;

import java.io.Serializable;

/**
 * (Cart)实体类
 *
 * @author makejava
 * @since 2022-09-15 15:32:30
 */
public class Cart implements Serializable {
    private static final long serialVersionUID = -70906424251759885L;
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
    
    private String tprice;


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

    public String getTprice() {
        return tprice;
    }

    public void setTprice(String tprice) {
        this.tprice = tprice;
    }

}

