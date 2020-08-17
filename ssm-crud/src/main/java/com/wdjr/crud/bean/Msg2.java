package com.wdjr.crud.bean;

import java.util.HashMap;
import java.util.Map;

//专门用来访问json数据
public class Msg2 {
	public static Msg2 success () {
		Msg2 result = new Msg2();
		result.setCode(100);
		result.setMsg("处理成功");
		return  result;
	}
	
	public static Msg2 fail () {
		Msg2 result = new Msg2();
		result.setCode(200);
		result.setMsg("处理失败");
		return  result;
	}
	public Msg2 add(String key ,Object value) {
		this.getExtend().put(key, value);
		return this;
	}
	
	
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getExtend() {
		return extend;
	}
	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
	
	private int code ;
	//提示信息
	private String msg;
	//用户要方会给浏览器的数据
	private Map<String, Object> extend = new HashMap<String, Object>();
	
}
