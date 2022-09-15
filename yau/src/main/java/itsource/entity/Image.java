package itsource.entity;

import java.io.Serializable;

/**
 * (Image)实体类
 *
 * @author makejava
 * @since 2022-09-15 15:32:32
 */
public class Image implements Serializable {
    private static final long serialVersionUID = -39738711683328113L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 图片标题
     */
    private String ititle;
    /**
     * 图片路径
     */
    private String iurl;
    /**
     * 图片类型 0：注册页面轮播图  1：产品轮播图图片等等 
     */
    private String itype;
    /**
     * 描述  如：注册页面轮播图
     */
    private String imsg;
    /**
     * 1:可用    0：禁用
     */
    private Integer istate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItitle() {
        return ititle;
    }

    public void setItitle(String ititle) {
        this.ititle = ititle;
    }

    public String getIurl() {
        return iurl;
    }

    public void setIurl(String iurl) {
        this.iurl = iurl;
    }

    public String getItype() {
        return itype;
    }

    public void setItype(String itype) {
        this.itype = itype;
    }

    public String getImsg() {
        return imsg;
    }

    public void setImsg(String imsg) {
        this.imsg = imsg;
    }

    public Integer getIstate() {
        return istate;
    }

    public void setIstate(Integer istate) {
        this.istate = istate;
    }

}

