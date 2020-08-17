package com.select.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Admin  implements Serializable {
	static final long serialVersionUID =1L;
    private Integer id;
    private String password;

}
