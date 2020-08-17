package com.select.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student  implements Serializable {
	static final long serialVersionUID =1L;
    private Integer id;
    private String password;
    private String name;
    private String sex;
    private String year;
    private String major;
}
