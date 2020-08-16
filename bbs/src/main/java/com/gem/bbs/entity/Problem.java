package com.gem.bbs.entity;

import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.annotation.DeclareAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Problem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer  id;
    private String   firsttitle;
    private String   description;
    private Integer  coin;
    private Integer  userid;
    private String   isup;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date     createtime;


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }


    public String getFirsttitle() {
        return firsttitle;
    }

    public void setFirsttitle(String firsttitle) {
        this.firsttitle = firsttitle;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }


    public String getIsup() {
        return isup;
    }

    public void setIsup(String isup) {
        this.isup = isup;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Problem() {
    }

    public Problem(Integer id, String firsttitle, String description, Integer coin, Integer userid, String isup, Date createtime) {
        this.id = id;
        this.firsttitle = firsttitle;
        this.description = description;
        this.coin = coin;
        this.userid = userid;
        this.isup = isup;
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", firsttitle='" + firsttitle + '\'' +
                ", description='" + description + '\'' +
                ", coin=" + coin +
                ", userid=" + userid +
                ", isup='" + isup + '\'' +
                ", createtime=" + createtime +
                '}';
    }


}
