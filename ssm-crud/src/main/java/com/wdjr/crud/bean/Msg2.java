package com.wdjr.crud.bean;

import java.util.HashMap;
import java.util.Map;

//ר����������json����
public class Msg2 {
	public static Msg2 success () {
		Msg2 result = new Msg2();
		result.setCode(100);
		result.setMsg("����ɹ�");
		return  result;
	}
	
	public static Msg2 fail () {
		Msg2 result = new Msg2();
		result.setCode(200);
		result.setMsg("����ʧ��");
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
	//��ʾ��Ϣ
	private String msg;
	//�û�Ҫ����������������
	private Map<String, Object> extend = new HashMap<String, Object>();
	
}
