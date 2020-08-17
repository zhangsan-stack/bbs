package com.select.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Course implements Serializable {
	static final long serialVersionUID =1L;
    private Integer id;
    private String  name;
    private String  time;
    private Integer credit;
    private String  belong;
    private String  place;
    private Integer amount;
    private String  detail;
    private Integer selected;
}
