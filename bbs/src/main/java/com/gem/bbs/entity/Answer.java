package com.gem.bbs.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Answer  implements Serializable {


    private static final long serialVersionUID = 1L;

    private Integer id;
    private String  content;
    private Integer questionid;
    private Integer userid;
    private String  isaccept;
    private Integer likes;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;



}
