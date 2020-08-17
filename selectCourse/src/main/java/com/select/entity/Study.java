package com.select.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Study implements Serializable {

   private Integer  id;
   private Integer  s_id;
   private String   s_name;
   private String   s_major;
   private Integer  c_id;
   private String   c_name;
   private String   c_belong;
   private Integer  c_credit;
   private String   c_time ;

}
