package com.gem.bbs.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Collections implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer questionid;
    private Integer userid;

}
