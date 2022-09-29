package itsource.entity;

import java.io.Serializable;

/**
 * (Type)实体类
 *
 * @author makejava
 * @since 2022-09-25 01:28:55
 */
public class Type implements Serializable {
    private static final long serialVersionUID = 534556634722340308L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 类型名称
     */
    private String typename;
    /**
     * 类型图片路径
     */
    private String timageurl;
    /**
     * 1:可用    0：禁用
     */
    private Integer tstate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getTimageurl() {
        return timageurl;
    }

    public void setTimageurl(String timageurl) {
        this.timageurl = timageurl;
    }

    public Integer getTstate() {
        return tstate;
    }

    public void setTstate(Integer tstate) {
        this.tstate = tstate;
    }

}

